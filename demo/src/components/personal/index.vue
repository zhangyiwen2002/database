<template>
  <div>
    <div class="head">
      <div class="pic">
        <van-image
          round
          width="7rem"
          height="7rem"
          lazy-load
          :src="headpic"
        ></van-image>
      </div>
      <div class="letter" @click="toLogin()" v-if="isLogin == 0">立即登录</div>
      <div class="letter" @click="toMessage()" v-else>{{ user.name }}</div>
    </div>
    <van-cell
      title="我的发表"
      is-link
      to="published"
      size="large"
      v-if="isLogin == 1"
    />
    <div class="exit">
      <van-button
        type="danger"
        round
        size="large"
        v-if="isLogin == 1"
        @click="exit()"
        >退出登录</van-button
      >
    </div>
  </div>
</template>

<script>
import { store } from "../../store/store";
import { userMessage } from "../../NetWork/user";
export default {
  name: "DemoIndex",
  created() {
    console.log(store.state.id);
    if (store.state.id != "") {
      this.isLogin = 1;
      userMessage(store.state.id).then((res) => {
        console.log(res);
        if (res.data.code == 200) {
          this.user = res.data.data;
          if (this.user.headPic != null) {
            console.log(this.user.headPic[0]);
            this.headpic = this.path + this.user.headPic;
          }
        }
      });
    } else {
      this.isLogin = 0;
    }
  },
  data() {
    return {
      isLogin: 0,
      user: {},
      headpic: "https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg",
      path: "http://47.92.77.49:8090/dbcd/headpic/",
    };
  },

  mounted() {},

  methods: {
    toLogin() {
      this.$router.push("/login");
    },
    exit() {
      store.clearMessageAction();
      this.headpic = "https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg";
      this.isLogin = 0;
    },
    toMessage() {
      this.$router.push("/message");
    },
  },
};
</script>

<style scoped>
.head {
  padding: 3rem 1rem;
}
.pic {
  text-align: center;
}
.letter {
  text-align: center;
  height: 2rem;
  line-height: 2rem;
  font-size: 20px;
  font-weight: 700;
  color: rgb(52, 136, 204);
}
.exit {
  padding: 2rem 2rem;
}
</style>