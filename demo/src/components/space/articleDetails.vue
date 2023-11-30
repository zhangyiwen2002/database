<template>
  <div>
    <div class="return"><van-icon name="revoke" @click="go()"></van-icon></div>
    <div class="whole">
      <div class="title">{{ article.title }}</div>
      <div class="info">
        <div class="date" v-text="getDate(article.date)"></div>
        <div class="name">
          <van-icon name="user-circle-o" size="18" />
          <div>{{ userName }}</div>
        </div>
      </div>
      <div class="content" v-html="article.content"></div>
      <van-grid :column-num="3">
        <van-grid-item
          v-for="(value, index) in article.picturePath"
          :key="value.id"
          @click="preview(index)"
          ><van-image :src="value"
        /></van-grid-item>
      </van-grid>
    </div>
  </div>
</template>

<script>
import { searchRecordsById } from "../../NetWork/article";
import { userMessage } from "../../NetWork/user";
import { ImagePreview } from "vant";
export default {
  name: "DemoSearchResults",
  async created() {
    await searchRecordsById(this.value).then((res) => {
      console.log(res);
      if (res.data.code == 200) {
        this.article = res.data.data;
        this.article.picturePath = this.article.picturePath.split(";");
        for (let i = 0; i < this.article.picturePath.length; i++) {
          if (this.article.picturePath[i] == "") {
            this.article.picturePath.splice(i, 1);
          } else {
            this.article.picturePath[i] =
              this.path + this.article.picturePath[i];
          }
        }
        console.log(this.article.picturePath);
        // console.log(this.article);
      }
    });
    await userMessage(parseInt(this.article.userId)).then((res) => {
      console.log(res);
      if (res.data.code == 200) {
        this.userName = res.data.data.name;
      }
    });
  },
  data() {
    return {
      value: parseInt(this.$route.params.id),
      article: {},
      userName: "",
      path: "http://47.92.77.49:8090/dbcd/uploadpic/",
    };
  },

  mounted() {},

  methods: {
    go() {
      this.$router.go(-1);
    },
    getDate(d) {
      let date = new Date(d);
      return (
        date.getFullYear() +
        "年" +
        (date.getMonth() + 1) +
        "月" +
        date.getDate() +
        "日 " +
        date.getHours() +
        ":" +
        date.getMinutes() +
        ":" +
        date.getSeconds()
      );
    },
    preview(index) {
      ImagePreview({
        images: this.article.picturePath,
        startPosition: index,
      });
    },
  },
};
</script>

<style scoped>
.return {
  height: 30px;
  line-height: 30px;
  font-size: 20px;
  padding-left: 10px;
  padding-top: 10px;
}
.whole {
  padding: 0 15px;
}
.title {
  height: 35px;
  line-height: 35px;
  font-size: 20px;
  font-weight: 700;
}
.info {
  height: 30px;
  line-height: 30px;
  font-size: 15px;
}
.date {
  float: left;
  color: #ccc;
}
.name {
  float: right;
  color: #aaa;
}
.name div {
  color: rgb(14, 129, 183);
  float: right;
  font-size: 13px;
  line-height: 26px;
}
.content {
  font-size: 15px;
  line-height: 25px;
  margin-bottom: 20px;
}
</style>