<template>
  <nav class="navbar navbar-expand-md">
    <button class="navbar-toggler" type="button" @click-="changeIsNavShow">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div :class="navClass" class="d-flex justify-content-center">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/">홈</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/products">상품목록</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/cart">장바구니</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>
<script setup>
import { reactive, computed } from 'vue';
const state = reactive({ isNavShow: false });
const navClass = computed(() =>
  state.isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'
);
const changeIsNavShow = () => {
  state.isNavShow = !state.isNavShow;
};
</script>
<style>
.navbar {
  box-shadow: 0px 0px 5px gray;
}
</style>
