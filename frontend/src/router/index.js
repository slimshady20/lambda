import Vue from "vue";
import VueRouter from "vue-router";
import Soccer from "@/components/Soccer";
import Home from "@/components/Home";
import Movie from "@/components/Movie";
Vue.use(VueRouter);
export default new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        { path: "/", component: Home },
        { path: "/soccer", component: Soccer },
        {path: "/movie", component: Movie}
    ]
});