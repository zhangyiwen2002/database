<template>
  <div class="whole">
    <van-form>
      <van-cell-group inset>
        <van-field
          v-model="user.name"
          name="用户名"
          label="用户名"
          placeholder="请输入用户名"
          required
          :rules="[{ required: true, message: '请填写用户名' }]"
        />
        <van-field
          v-model="user.password"
          type="password"
          name="密码"
          label="密码"
          placeholder="请输入密码"
          required
          :rules="[{ required: true, message: '请填写密码' }]"
        />

        <van-field
          v-model="user.phone"
          name="手机号"
          label="手机号"
          type="tel"
          placeholder="请输入手机号"
          required
          :rules="[
            { pattern: phonepattern, message: '请输入合法的手机号' },
            { required: true, message: '请输入手机号' },
          ]"
        />
        <van-field name="uploader" label="头像上传">
          <template #input>
            <van-uploader v-model="user.fileList" multiple :max-count="1" />
          </template>
        </van-field>
      </van-cell-group>

      <div style="margin: 16px">
        <van-button
          round
          block
          type="primary"
          native-type="submit"
          @click="submit"
        >
          注册
        </van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import { register } from "@/NetWork/user";
export default {
  name: "DemoRegister",

  data() {
    return {
      user: {
        name: "",
        password: "",
        phone: "",
        fileList: [],
      },
      phonepattern:
        /(^|\s*\+?0?0?86|\D)(1\d{2})[-\s]{0,3}(\d{4})[-\s]{0,3}(\d{4})(?=\D|$)/,
    };
  },

  mounted() {},

  methods: {
    submit() {
      register(
        this.user.name,
        this.user.password,
        this.user.phone,
        this.user.fileList
      ).then((res) => {
        console.log(res);
        if (res.data.code == 200) {
          this.$toast("注册成功");
          this.$router.replace("/login");
        } else if (res.data.code == 4001) {
          this.$toast(res.data.message);
        } else {
          this.$toast("注册失败");
        }
      });
    },
  },
};
</script>

<style scoped>
.whole {
  margin-top: 20px;
}
</style>