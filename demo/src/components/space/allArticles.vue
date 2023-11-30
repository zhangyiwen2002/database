<template>
  <div class="box">
    <van-list
      v-model="allrecords.loading"
      :finished="allrecords.finished"
      finished-text="已经到底了哦"
      @load="onLoad"
    >
      <div
        v-for="item in allrecords.data"
        :key="item.id"
        class="whole"
        @click="toDetails(item.id)"
      >
        <div class="title">{{ item.title }}</div>
        <div class="content">
          <span class="date" v-text="getDate(item.date)"></span>|
          <span class="article ellipsis">{{ item.content }}</span>
        </div>
      </div>
    </van-list>
  </div>
</template>

<script>
import { getAllRecords } from "../../NetWork/article";
export default {
  name: "DemoAllArticles",
  created() {},
  data() {
    return {
      allrecords: {
        code: "",
        data: [],
        loading: false,
        finished: false,
        cnt: 0,
      },
    };
  },

  mounted() {},

  methods: {
    onLoadRecords(allrecords, res) {
      console.log(res);
      allrecords.code = res.data.code;
      allrecords.loading = true;
      if (allrecords.code == 200) {
        allrecords.loading = false;
        for (let i = 0; i < 10; i++) {
          if (allrecords.data.length < res.data.data.length) {
            allrecords.data[allrecords.cnt] = res.data.data[allrecords.cnt];
            allrecords.cnt++;
          }
        }
        allrecords.loading = false;
        if (res.data.data.length <= allrecords.data.length) {
          //数据全部加载完成
          allrecords.finished = true;
          allrecords.cnt = 0;
        } else {
          allrecords.finished = false;
        }
      }
    },
    onLoad() {
      setTimeout(() => {
        getAllRecords().then((res) => {
          this.onLoadRecords(this.allrecords, res);
        });
      }, 1000);
    },
    getDate(d) {
      let date = new Date(d);
      return (
        date.getFullYear() +
        "年" +
        (date.getMonth() + 1) +
        "月" +
        date.getDate() +
        "日"
      );
    },

    toDetails(id) {
      this.$router.push("/articledetails/" + id);
    },
  },
};
</script>

<style scoped>
.ellipsis {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.bigtitle {
  font-size: 20px;
  height: 60px;
  line-height: 60px;
  padding-left: 10px;
}
.whole {
  height: 80px;
  margin: 10px 20px;
  border-radius: 8px;
  padding: 0 15px;
  background-color: #eee;
}
.title {
  height: 40px;
  line-height: 50px;
  font-size: 20px;
  font-weight: 700;
}
.content {
  height: 40px;
  line-height: 40px;
  font-size: 15px;
  color: #ccc;
}
</style>