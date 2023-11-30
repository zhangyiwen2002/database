<template>
  <div class="box">
    <van-sticky>
      <div class="bigtitle">
        分享交流
        <span class="add">
          <van-button type="warning" round @click="toPublish()"
            ><van-icon name="plus"
          /></van-button>
        </span>
      </div>

      <van-search
        v-model="value"
        shape="round"
        placeholder="请输入记忆中的帖子名称哦"
        show-action
        @search="onSearch"
        @cancel="onCancel"
      ></van-search>
    </van-sticky>
    <router-view></router-view>
  </div>
</template>

<script>
import { store } from "@/store/store";
export default {
  name: "DemoIndex",
  created() {},
  data() {
    return {
      value: this.$route.query.name,
    };
  },

  mounted() {},
  beforeRouteUpdate(to, from, next) {
    // console.log(
    //   "路由更新之前：从to获取参数",
    //   to.query,
    //   "从this.$route获取参数",
    //   this.$route.query
    // );
    next();
    // console.log(
    //   "路由更新之后：从to获取参数",
    //   to.query,
    //   "从this.$route获取参数",
    //   this.$route.query
    // );
    this.value = this.$route.query.name;
  },
  methods: {
    onCancel() {
      this.$router.push("/space/all");
    },
    onSearch() {
      this.$router.push({
        path: "/space/search",

        query: {
          name: this.value,
        },
      });
    },
    toPublish() {
      if (store.state.id == "") {
        this.$toast("请先登录");
      } else {
        this.$router.push("/publish");
      }
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
  padding: 10px;
  background-color: #fff;
}
.add {
  float: right;
  font-size: 25px;
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