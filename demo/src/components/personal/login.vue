<template>
  <div class="whole">
    <van-form>
      <van-cell-group inset>
        <van-field
          v-model="username"
          name="手机号"
          label="手机号"
          placeholder="请输入手机号"
          type="tel"
          :rules="[{ pattern: phonepattern, message: '请填写合法的手机号' }]"
        />
        <van-field
          v-model="password"
          type="password"
          name="密码"
          placeholder="请输入密码"
          label="密码"
          :rules="[{ required: true, message: '请填写密码' }]"
        />
      </van-cell-group>
      <div class="submit">
        <div class="login">
          <van-button round type="primary" size="large" @click="login()">
            登录
          </van-button>
        </div>
        <div class="register">
          <van-button round type="warning" to="/register" size="large">
            注册
          </van-button>
        </div>
      </div>
    </van-form>
  </div>
</template>

<script>
import { store } from "@/store/store";
import { login } from "../../NetWork/user";
export default {
  name: "DemoLogin",

  data() {
    return {
      username: "",
      password: "",
      message: "",
      phonepattern:
        /(^|\s*\+?0?0?86|\D)(1\d{2})[-\s]{0,3}(\d{4})[-\s]{0,3}(\d{4})(?=\D|$)/,
    };
  },

  mounted() {},

  methods: {
    login() {
      login(this.username, this.password).then((res) => {
        console.log(res);
        if (res.data.code == 200) {
          store.setMessageAction(res.data.data, this.password, this.username);
          this.$toast("登陆成功");
          this.$router.push("/personal");
        } else if (res.data.code == 4002) {
          this.message = res.data.message;
          this.$toast(this.message);
        } else {
          this.$toast("登录失败");
        }
      });
    },
  },
};
</script>

<style scoped>
.whole {
  padding-top: 80px;
}
.submit {
  text-align: center;
  padding: 20px 0;
}
.register,
.login {
  float: left;
  width: 40%;
  padding: 0 5%;
}
</style>