const store = {
    debug: true,
  
    state: {
        id:localStorage.getItem('id')==null?'':localStorage.getItem('id'),
        password:localStorage.getItem('password')==null?'':localStorage.getItem('password'),
        phone:localStorage.getItem('phone')==null?'':localStorage.getItem('phone'),
    },
  
    setMessageAction(id,password,phone) {
      if (this.debug) {
        console.log('setMessageAction triggered with', id)
      }
  
      this.state.id = id;
      this.state.password=password;
      this.state.phone=phone;
      localStorage.setItem('id',id);
      localStorage.setItem('phone',phone);
      localStorage.setItem('password',password);
    },
  
    clearMessageAction() {
      if (this.debug) {
        console.log('clearMessageAction triggered')
      }
      localStorage.clear();
      this.state.id = ''
      this.state.password = ''
      this.state.phone = ''
    }
}
export{store}