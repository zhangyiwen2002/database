"use strict";(self["webpackChunkdemo"]=self["webpackChunkdemo"]||[]).push([[831],{5831:function(e,t,s){s.r(t),s.d(t,{default:function(){return h}});var a=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticClass:"head"},[t("div",{staticClass:"pic"},[t("van-image",{attrs:{round:"",width:"7rem",height:"7rem","lazy-load":"",src:e.headpic}})],1),0==e.isLogin?t("div",{staticClass:"letter",on:{click:function(t){return e.toLogin()}}},[e._v("立即登录")]):t("div",{staticClass:"letter",on:{click:function(t){return e.toMessage()}}},[e._v(e._s(e.user.name))])]),1==e.isLogin?t("van-cell",{attrs:{title:"我的发表","is-link":"",to:"published",size:"large"}}):e._e(),t("div",{staticClass:"exit"},[1==e.isLogin?t("van-button",{attrs:{type:"danger",round:"",size:"large"},on:{click:function(t){return e.exit()}}},[e._v("退出登录")]):e._e()],1)],1)},n=[],o=s(6138),i=s(7378),r={name:"DemoIndex",created(){console.log(o.h.state.id),""!=o.h.state.id?(this.isLogin=1,(0,i.O)(o.h.state.id).then((e=>{console.log(e),200==e.data.code&&(this.user=e.data.data,null!=this.user.headPic&&(console.log(this.user.headPic[0]),this.headpic=this.path+this.user.headPic))}))):this.isLogin=0},data(){return{isLogin:0,user:{},headpic:"https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg",path:"http://47.92.77.49:8090/dbcd/headpic/"}},mounted(){},methods:{toLogin(){this.$router.push("/login")},exit(){o.h.clearMessageAction(),this.headpic="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg",this.isLogin=0},toMessage(){this.$router.push("/message")}}},l=r,d=s(1001),c=(0,d.Z)(l,a,n,!1,null,"4b864052",null),h=c.exports},7378:function(e,t,s){s.d(t,{$M:function(){return d},O:function(){return l},x4:function(){return r},z2:function(){return i}});var a=s(6138),n=s(9669),o=s.n(n);function i(e,t,s,a){const n=new FormData;return n.append("name",e),n.append("password",t),n.append("phone",s),0!=a.length?n.append("file",a[0].file):n.append("file",new File([],"")),new Promise(((e,t)=>{o()({method:"post",url:"user/register",data:n}).then((t=>{e(t)})).catch((e=>{t(e)}))}))}function r(e,t){const s=new URLSearchParams;return s.append("phone",e),s.append("password",t),new Promise(((e,t)=>{o()({method:"post",url:"user/login",headers:{"Content-Type":"application/x-www-form-urlencoded"},data:s}).then((t=>{e(t)})).catch((e=>{t(e)}))}))}function l(e){return new Promise(((t,s)=>{o()({method:"get",url:"user/message?id="+e}).then((e=>{t(e)})).catch((e=>{s(e)}))}))}function d(e,t,s,n,i){console.log(a.h.state.phone),parseInt(n)!=a.h.state.phone&&r.append("phone",n);const r=new FormData;return r.append("id",e),r.append("name",t),r.append("password",s),0!=i.length?r.append("file",i[0].file):r.append("file",new File([],"")),new Promise(((e,t)=>{o()({method:"post",url:"user/update",data:r}).then((t=>{e(t)})).catch((e=>{t(e)}))}))}o().defaults.baseURL="http://47.92.77.49:8080/",o().defaults.timeout=5e4},6138:function(e,t,s){s.d(t,{h:function(){return a}});const a={debug:!0,state:{id:null==localStorage.getItem("id")?"":localStorage.getItem("id"),password:null==localStorage.getItem("password")?"":localStorage.getItem("password"),phone:null==localStorage.getItem("phone")?"":localStorage.getItem("phone")},setMessageAction(e,t,s){this.debug&&console.log("setMessageAction triggered with",e),this.state.id=e,this.state.password=t,this.state.phone=s,localStorage.setItem("id",e),localStorage.setItem("phone",s),localStorage.setItem("password",t)},clearMessageAction(){this.debug&&console.log("clearMessageAction triggered"),localStorage.clear(),this.state.id="",this.state.password="",this.state.phone=""}}}}]);
//# sourceMappingURL=831.364648b1.js.map