import Vue from 'vue'
import Router from 'vue-router'
import index from '../page/index'
import login from '../page/user/login'
import axios_1 from "../page/axiosT/axios_1"
import businessLogin from '../page/business/businessLogin'
import businessIndex from '../page/business/businessIndex'
import insertCommodityCategory from "../components/business/BusinessInsert/insertCommodityCategory";
import insertCommodity_Book from "../components/business/BusinessInsert/insertCommodity_Book"
import insertCommodity_Computer from "../components/business/BusinessInsert/insertCommodity_Computer"
import checkCommodity from "../components/business/BusinessInsert/checkCommodity"
import businessInfo from "../components/business/BusinessInsert/businessInfo"
import businessCommodity from "../components/business/BusinessInsert/businessCommodity"
import editBookCommodities from "../components/business/BusinessInsert/editCommodities/editBookCommodities"
import insertCommodityPage from "../components/business/BusinessInsert/insertCommodity/insertCommodityPage"
import editImg from "../components/business/BusinessInsert/editCommodities/editImg"
import editComputerCommodities from "../components/business/BusinessInsert/editCommodities/editComputerCommodities";
import bookPage from "../page/categoryPage/bookPage";
import buyPage from "../page/otherPage/buyPage";
import buyBookPage from "../page/otherPage/buyBookPage";
import shopCartPage from "../page/shop/shopCartPage";
import paymentPage from "../components/index/shopping_cart/paymentPage";
import orderPage from "../components/business/BusinessInsert/order/orderPage";
import userHome from "../page/user/userHome";
import homeUserInfo from "../components/user/home/homeUserInfo";
import registerUser from "../page/user/registerUser";
import address from "../components/user/home/address";
import searchPage from "../page/search/searchPage";
import commodityPage from "../page/categoryPage/commodityPage";
import displayCommodity from "../page/Commodity/displayCommodity";
import buyComputerPage from "../page/otherPage/buyComputerPage";
import computerPage from "../page/categoryPage/computerPage";
import adminLogin from "../page/admin/adminLogin";
import adminHome from "../page/admin/adminHome";
import addSuccess from "../page/otherPage/addShopCart/addSuccess";
import adminOther from "../components/admin/adminOther";
import merchantHome from "../page/merchant/merchantHome";
import addCommodityPage from "../components/business/addCommodity/addCommodityPage";
import CommodityImgPage from "../page/Commodity/CommodityImg/CommodityImgPage";
import editPage from "../page/Commodity/editPage/editPage";
import buyPhonePage from "../page/otherPage/buyPhonePage";
import phonePage from "../page/categoryPage/phonePage";
import userOrderInfo from "../components/user/home/userOrderInfo";
import clothPage from "../page/categoryPage/clothPage";
import buyClothPage from "../page/otherPage/buyClothPage";
import editBook from "../page/Commodity/editPage/editBook";
import businessCommodityPage from "../page/business/commodity/businessCommodityPage";
import furniturePage from "../page/categoryPage/furniturePage";
import buyFurniturePage from "../page/otherPage/buyFurniturePage";
import foodPage from "../page/categoryPage/foodPage";
import buyFoodPage from "../page/otherPage/buyFoodPage";
import businessRegister from "../page/business/businessRegister";
import buyOtherPage from "../page/otherPage/buyOtherPage";
import merchantIndex from "../components/business/merchant/merchantIndex";
import AllCommodityPage from "../components/business/Commodity/AllCommodityPage";
import editCommodityPage from "../page/business/commodity/editCommodityPage";
import userSecurity from "../components/user/home/userSecurity";
import findPasswordPage from "../page/user/userOtherPage/findPasswordPage";
import userAddressPage from "../page/user/userOtherPage/userAddressPage";
import applyPage from "../page/admin/adminOtherPage/applyPage";
import SecurityManagerPage from "../page/admin/adminOtherPage/SecurityManagerPage";
import editTypePage from "../page/user/userOtherPage/editTypePage";
import ManagerAllMerchant from "../page/admin/adminOtherPage/ManagerAllMerchant";
import orderDeliverPage from "../components/business/BusinessInsert/order/otOrder/orderDeliverPage";
import orderReceivePage from "../components/business/BusinessInsert/order/otOrder/orderReceivePage";
import allMerOrderPage from "../components/business/BusinessInsert/order/otOrder/allMerOrderPage";
import adminManagerIndexPage from "../page/admin/adminOtherPage/adminManagerIndexPage";
import orderMainPage from "../page/business/orderPage/orderMainPage";
import logisticsIndex from "../page/logistics/logisticsIndex";
import order_deliverPage from "../page/business/orderPage/order_deliverPage";
import order_finishPage from "../page/business/orderPage/order_finishPage";
import order_noLogisticsPage from "../page/business/orderPage/order_noLogisticsPage";
import userOrderPage from "../page/user/userOtherPage/userOrderPage";
import editCategoryPage from "../page/admin/adminOtherPage/editCategoryPage";
import BookIndexPage from "../page/Commodity/CommodityPage/BookPage/BookIndexPage";
import testMarkdown from "../page/test/testMarkdown";
import paySuccess from "../components/index/shopping_cart/paySuccess";
import ComputerIndexPage from "../page/Commodity/CommodityPage/ComputerPage/ComputerIndexPage";
import PhoneIndexPage from "../page/Commodity/CommodityPage/PhonePage/PhoneIndexPage";
import FurnitureIndexPage from "../page/Commodity/CommodityPage/FurniturePage/FurnitureIndexPage";
import ClothIndexPage from "../page/Commodity/CommodityPage/ClothPage/ClothIndexPage";
import FoodIndexPage from "../page/Commodity/CommodityPage/FoodPage/FoodIndexPage";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path : '/',
      component : index,
      meta : {
        title : '淘淘乐'
      }
    },
    {
      path : '/adminLogin',
      component : adminLogin
    },
    {
      path : '/adminHome',
      component : adminHome,
      children : [
        {
          //
          path : '/adminOther',
          component : adminOther
        },
        {
          path : '/applyPage',
          component : applyPage
        },
        {
          path : '/SecurityManagerPage',
          component : SecurityManagerPage
        },
        {
          path : '/editTypePage',
          component : editTypePage
        },
        {
          path : '/ManagerAllMerchant',
          component : ManagerAllMerchant
        },
        {
          path : '/adminManagerIndexPage',
          component : adminManagerIndexPage
        },
        {
          path : '/editCategoryPage',
          component : editCategoryPage
        }
      ]
    },
    {
      path : '/index',
      component : index
    },
    {
      path : '/login',
      component : login
    },
    {
      path : '/findPasswordPage',
      component : findPasswordPage
    },
    {
      path : '/searchPage',
      component : searchPage
    },
    {
      path : '/displayCommodity',
      component : displayCommodity
    },
    {
      path : '/commodityPage',
      component : commodityPage
    },
    {
     path : '/addSuccess',
     component : addSuccess
    },
    {
      path : '/userHome',
      component : userHome,
      children : [
        {
          path : '/homeUserInfo',
          component : homeUserInfo
        },
        {
          path : '/address',
          component : address
        },
        {
          path : '/userOrderInfo',
          component : userOrderInfo
        }
      ]
    },
    {
      path : '/userOrderPage',
      component : userOrderPage
    },
    {
      path : '/userAddressPage',
      component : userAddressPage
    },
    {
      path : '/registerUser',
      component : registerUser
    },
    {
      //axios_1
      path : '/axios_1',
      component: axios_1
    },
    {
      path : '/userSecurity',
      component : userSecurity
    },
    {
      path : '/businessLogin',
      component : businessLogin,
      meta : {
        title : '商家'
      }
    },
    {
      path : '/businessRegister',
      component : businessRegister
    },
    {
      path : '/orderMainPage',
      component : orderMainPage,
      children : [
        {
          path : '/order_deliverPage',
          component : order_deliverPage
        },
        {
          path : '/order_finishPage',
          component : order_finishPage
        },
        {
          path : '/order_noLogisticsPage',
          component : order_noLogisticsPage
        }
      ]
    },
    {
      path : '/AllCommodityPage',
      component : AllCommodityPage
    },
    {
      path :'/addCommodityPage',
      component : addCommodityPage
    },
    {
      path : '/businessIndex',
      component : businessIndex,
      props : true,
      children : [
        {
          path : '/insertCommodityCategory',
          component: insertCommodityCategory,
          children : [
            {
              path : '/insertCommodity_Book',
              component : insertCommodity_Book
            },
            {
              path: '/insertCommodity_Computer',
              component: insertCommodity_Computer
            }
          ]
        },

        {
          path : '/editCommodityPage',
          component : editCommodityPage
        },

        {
          path : '/orderPage',
          component : orderPage,
          children : [
            {
              path : '/orderDeliverPage',
              component: orderDeliverPage
            },
            {
              path : '/orderReceivePage',
              component : orderReceivePage
            },
            {
              path : '/allMerOrderPage',
              component : allMerOrderPage
            }
          ]
        },
        {
          path : '/checkCommodity',
          component :checkCommodity
        },
        {
          path : '/insertCommodityPage',
          component : insertCommodityPage
        },
        {
          path : '/businessInfo',
          component: businessInfo
        },
        {
          path: '/businessCommodity',
          component: businessCommodity
        },
        {
          path : '/editBookCommodities',
          component: editBookCommodities
        },
        {
          path : '/editComputerCommodities',
          component : editComputerCommodities
        },
        {
          path : '/editImg',
          component : editImg
        },
        {
          path : '/CommodityImgPage',
          component : CommodityImgPage
        },
        {
          path : '/editPage',
          component : editPage
        },
        {
          path : '/businessCommodityPage',
          component : businessCommodityPage
        }
      ]
    },
    {
      path : '/buyPage',
      component : buyPage
    },
    {
      path : '/shopCartPage',
      component : shopCartPage
    },
    {
      path : '/paymentPage',
      component : paymentPage
    },
    {
      path : '/buyBookPage',
      component : buyBookPage
    },
    {
      path : '/buyComputerPage',
      component : buyComputerPage
    },
    {
      path :'/bookPage',
      component : bookPage
    },
    {
      path : '/computerPage',
      component : computerPage
    },
    {
      path : '/furniturePage',
      component : furniturePage
    },
    {
      path : '/phonePage',
      component : phonePage
    },
    {
      path : '/merchantHome',
      component : merchantHome
    },
    {
      path : '/buyPhonePage',
      component : buyPhonePage
    },
    {
      path : '/clothPage',
      component : clothPage,
    },
    {
      path: '/buyClothPage',
      component : buyClothPage
    },
    {
      path : '/buyFurniturePage',
      component : buyFurniturePage
    },
    {
      path : '/foodPage',
      component : foodPage
    },
    {
      path : '/buyFoodPage',
      component : buyFoodPage
    },
    {
      path : '/buyOtherPage',
      component : buyOtherPage
    },
    {
      path : '/merchantIndex',
      component : merchantIndex
    },
    {
      path : '/logisticsIndex',
      component : logisticsIndex
    },
    {
      path : '/BookIndexPage',
      component : BookIndexPage
    },
    {
      path : '/testMarkdown',
      component : testMarkdown
    },
    {
      path : '/paySuccess',
      component : paySuccess
    },
    {
      path : '/ComputerIndexPage',
      component : ComputerIndexPage
    },
    {
      path : '/PhoneIndexPage',
      component : PhoneIndexPage
    },
    {
      path : '/FurnitureIndexPage',
      component : FurnitureIndexPage
    },
    {
      path : '/ClothIndexPage',
      component : ClothIndexPage
    },
    {
      path : '/FoodIndexPage',
      component : FoodIndexPage
    }

  ]
})
