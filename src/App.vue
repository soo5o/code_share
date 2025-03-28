<template>
  <Header></Header>
  <div class="layout">
    <router-view name="left" />
    <!-- 좌측 필터 -->
    <main class="main">
      <router-view class="page mt-3" />
      <!-- 기본 콘텐츠 -->
    </main>
  </div>
</template>
<script setup>
import Header from '@/components/Header.vue';
import { provide, reactive } from 'vue';

const state = reactive({ cart: [] });

const addToCart = (product) => {
  state.cart.push(product);
};

provide('cartState', state);
provide('addToCart', addToCart);
</script>
<style>
.page {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
<!--
명명된 뷰 /products 경로에서 좌측 필터 영역 + 우측 상품 목록 나누기
중첩 라우트 /products/:id 안에서 상세정보/리뷰 탭 구성
실습 개념 components: { default, left }, <router-view name="left"> + children 라우트
-->
