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
        <van-field name="uploader" label="更新头像上传">
          <template #input>
            <van-uploader v-model="fileList" multiple :max-count="1" />
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
          更新
        </van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import { userMessage, updateUserMessage } from "@/NetWork/user";
import { store } from "@/store/store";
export default {
  name: "DemoRegister",
  created() {
    userMessage(store.state.id).then((res) => {
      console.log(res);
      if (res.data.code == 200) {
        this.user = res.data.data;
      }
    });
  },
  data() {
    return {
      user: {
        name: "",
        password: "",
        phone: "",
      },
      fileList: [],
      path: "http://47.92.77.49:8090/dbcd/headpic/",
      phonepattern:
        /(^|\s*\+?0?0?86|\D)(1\d{2})[-\s]{0,3}(\d{4})[-\s]{0,3}(\d{4})(?=\D|$)/,
    };
  },

  mounted() {},

  methods: {
    submit() {
      updateUserMessage(
        store.state.id,
        this.user.name,
        this.user.password,
        this.user.phone,
        this.fileList
      ).then((res) => {
        console.log(res);
        if (res.data.code == 200) {
          this.$toast("用户个人信息更新成功");
          store.setMessageAction(
            store.state.id,
            this.user.password,
            this.user.phone
          );
          this.$router.go(-1);
        } else if (res.data.code == 4001) {
          this.$toast(res.data.message);
        } else {
          this.$toast("用户个人信息更新失败");
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