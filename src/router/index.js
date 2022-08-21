import { createRouter, createWebHistory } from 'vue-router'
import AddCategory from "../views/Category/AddCategory";
import Category from "../views/Category/Category";
import EditCategory from "@/views/Category/EditCategory";
import AddProduct from "@/views/product/AddProduct";
import Product from "@/views/product/Product";
import EditProduct from "@/views/product/EditProduct";
import HomeView from "@/views/HomeView";
import ShowDetails from "../views/product/ShowDetails";
import Signup from "@/views/Signup";
import Signin from "@/views/Signin";
import WishList from "@/views/product/WishList";
import Success from "@/views/payment/success";
import Failed from "@/views/payment/failed";
import Checkout from "@/views/checkout/Checkout";
import OrderHistory from "@/views/order/OrderHistory";
import OrderDetails from "@/views/order/OrderDetails";

const routes = [
  {
    path: "/",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/admin/category/add",
    name: "AddCategory",
    component: AddCategory,
  },
  {
    path: "/admin/category",
    name: "AdminCategory",
    component: Category,
  },
  {
    path: "/admin/category/:id",
    name: "EditCategory",
    component: EditCategory
  },
  {
    path: "/admin/product/add",
    name: "AddProduct",
    component: AddProduct,
  },
  {
    path: "/admin/product",
    name: "AdminProduct",
    component: Product,
  },
  {
    path: "/admin/product/:id",
    name: "EditProduct",
    component: EditProduct,
  },
  {
    path : '/product/show/:id',
    name : 'ShowDetails',
    component: ShowDetails
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/signin',
    name: 'Signin',
    component: Signin
  },
  {
    path: '/wishlist',
    name: 'WishList',
    component: WishList
  },
  {
    path: '/payment/success',
    name: 'PaymentSuccess',
    component:Success
  },
  {
    path: '/payment/failed',
    name: 'FailedPayment',
    component:Failed
  },
  {
    path : '/checkout',
    name : 'Checkout',
    component : Checkout
  },
  {
    path: '/orders',
    name: 'OrderHistory',
    component: OrderHistory
  },
  {
    path:'/order/:id',
    name:'OrderDetails',
    component: OrderDetails
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
