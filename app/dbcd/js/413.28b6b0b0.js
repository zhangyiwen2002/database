"use strict";(self["webpackChunkdemo"]=self["webpackChunkdemo"]||[]).push([[413],{413:function(e,t,s){s.r(t),s.d(t,{default:function(){return d}});var a=function(){var e=this,t=e._self._c;return t("div",{staticClass:"whole"},[t("van-form",[t("van-cell-group",{attrs:{inset:""}},[t("van-field",{attrs:{name:"用户名",label:"用户名",placeholder:"请输入用户名",required:"",rules:[{required:!0,message:"请填写用户名"}]},model:{value:e.user.name,callback:function(t){e.$set(e.user,"name",t)},expression:"user.name"}}),t("van-field",{attrs:{type:"password",name:"密码",label:"密码",placeholder:"请输入密码",required:"",rules:[{required:!0,message:"请填写密码"}]},model:{value:e.user.password,callback:function(t){e.$set(e.user,"password",t)},expression:"user.password"}}),t("van-field",{attrs:{name:"手机号",label:"手机号",type:"tel",placeholder:"请输入手机号",required:"",rules:[{pattern:e.phonepattern,message:"请输入合法的手机号"},{required:!0,message:"请输入手机号"}]},model:{value:e.user.phone,callback:function(t){e.$set(e.user,"phone",t)},expression:"user.phone"}}),t("van-field",{attrs:{name:"uploader",label:"头像上传"},scopedSlots:e._u([{key:"input",fn:function(){return[t("van-uploader",{attrs:{multiple:"","max-count":1},model:{value:e.user.fileList,callback:function(t){e.$set(e.user,"fileList",t)},expression:"user.fileList"}})]},proxy:!0}])})],1),t("div",{staticStyle:{margin:"16px"}},[t("van-button",{attrs:{round:"",block:"",type:"primary","native-type":"submit"},on:{click:e.submit}},[e._v(" 注册 ")])],1)],1)],1)},n=[],o=s(7378),r={name:"DemoRegister",data(){return{user:{name:"",password:"",phone:"",fileList:[]},phonepattern:/(^|\s*\+?0?0?86|\D)(1\d{2})[-\s]{0,3}(\d{4})[-\s]{0,3}(\d{4})(?=\D|$)/}},mounted(){},methods:{submit(){(0,o.z2)(this.user.name,this.user.password,this.user.phone,this.user.fileList).then((e=>{console.log(e),200==e.data.code?(this.$toast("注册成功"),this.$router.replace("/login")):4001==e.data.code?this.$toast(e.data.message):this.$toast("注册失败")}))}}},l=r,i=s(1001),u=(0,i.Z)(l,a,n,!1,null,"d7d51fc8",null),d=u.exports},7378:function(e,t,s){s.d(t,{$M:function(){return u},O:function(){return i},x4:function(){return l},z2:function(){return r}});var a=s(6138),n=s(9669),o=s.n(n);function r(e,t,s,a){const n=new FormData;return n.append("name",e),n.append("password",t),n.append("phone",s),0!=a.length?n.append("file",a[0].file):n.append("file",new File([],"")),new Promise(((e,t)=>{o()({method:"post",url:"user/register",data:n}).then((t=>{e(t)})).catch((e=>{t(e)}))}))}function l(e,t){const s=new URLSearchParams;return s.append("phone",e),s.append("password",t),new Promise(((e,t)=>{o()({method:"post",url:"user/login",headers:{"Content-Type":"application/x-www-form-urlencoded"},data:s}).then((t=>{e(t)})).catch((e=>{t(e)}))}))}function i(e){return new Promise(((t,s)=>{o()({method:"get",url:"user/message?id="+e}).then((e=>{t(e)})).catch((e=>{s(e)}))}))}function u(e,t,s,n,r){console.log(a.h.state.phone),parseInt(n)!=a.h.state.phone&&l.append("phone",n);const l=new FormData;return l.append("id",e),l.append("name",t),l.append("password",s),0!=r.length?l.append("file",r[0].file):l.append("file",new File([],"")),new Promise(((e,t)=>{o()({method:"post",url:"user/update",data:l}).then((t=>{e(t)})).catch((e=>{t(e)}))}))}o().defaults.baseURL="http://47.92.77.49:8080/",o().defaults.timeout=5e4},6138:function(e,t,s){s.d(t,{h:function(){return a}});const a={debug:!0,state:{id:null==localStorage.getItem("id")?"":localStorage.getItem("id"),password:null==localStorage.getItem("password")?"":localStorage.getItem("password"),phone:null==localStorage.getItem("phone")?"":localStorage.getItem("phone")},setMessageAction(e,t,s){this.debug&&console.log("setMessageAction triggered with",e),this.state.id=e,this.state.password=t,this.state.phone=s,localStorage.setItem("id",e),localStorage.setItem("phone",s),localStorage.setItem("password",t)},clearMessageAction(){this.debug&&console.log("clearMessageAction triggered"),localStorage.clear(),this.state.id="",this.state.password="",this.state.phone=""}}}}]);
//# sourceMappingURL=413.28b6b0b0.js.map