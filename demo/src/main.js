import Vue from 'vue'
import App from './App.vue'
import router from './Router/index'
Vue.config.productionTip = false
import { Tabbar, TabbarItem } from 'vant';
import 'vant/lib/index.css'
import { Calendar } from 'vant';
import { Button } from 'vant';
import { Search } from 'vant';
import { List } from 'vant';
import { Lazyload } from 'vant';
import { Image as VanImage } from 'vant';
import { Cell, CellGroup } from 'vant';
import { Icon } from 'vant';
import { Form, Field} from 'vant';
import { Uploader } from 'vant';
import { Toast } from 'vant';
import { Tab, Tabs } from 'vant';
import { Sticky } from 'vant';
import { NavBar } from 'vant';
import { Grid, GridItem } from 'vant';
import { ImagePreview } from 'vant';
import { SwipeCell } from 'vant';
import { Switch } from 'vant';
Vue.use(Switch).use(SwipeCell).use(ImagePreview).use(Grid).use(GridItem).use(NavBar).use(Tabbar).use(TabbarItem).use(Calendar).use(Button).use(Search).use(List).use(Lazyload).use(VanImage).use(Cell).use(CellGroup).use(Icon).use(Field).use(Form).use(Uploader).use(Toast).use(Tab).use(Tabs).use(Sticky)
Vue.prototype.$ImagePreview = ImagePreview
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
