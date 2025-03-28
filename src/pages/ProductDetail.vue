<!--useRoute() 사용해서 params.id 읽기
products.json에서 해당 ID에 맞는 상품 찾기
상세 정보(이름, 가격, 이미지) 출력 -->
<template>
  <div class="card mb-5">
    <div class="text-center">{{ product.name }}</div>
    <img :src="product.image" width="500px" class="rounded-3" />
    <div class="text-center m-3">
      가격: {{ product.price.toLocaleString() }}원
    </div>
    <button class="btn btn-primary mb-5" @click="addItem(product)">
      장바구니 담기
    </button>
    <div>
      <router-link
        class="btn"
        :to="`/products/${product.id}`"
        exact-active-class="active-tab"
        >상세정보</router-link
      >
      <router-link
        class="btn"
        :to="`/products/${product.id}/review`"
        exact-active-class="active-tab"
        >리뷰</router-link
      >
      <router-view exact-active-class="active-tab" />
      <!-- 로 탭별 컴포넌트가 렌더링되어야 함 -->
    </div>
  </div>
</template>
<script setup>
import products from '@/data/products.json';
import { useRoute } from 'vue-router';
import { inject } from 'vue';
const idx = useRoute().params.id;
let product;
for (let p of products) {
  if (p.id == idx) {
    product = p;
    break;
  }
}
const addToCart = inject('addToCart');
const addItem = (product) => {
  addToCart(product);
};
</script>
<!-- 2. ProductDetail.vue에서 상품 담기 기능 구현
inject('addToCart')로 함수 받아오기
"장바구니 담기" 버튼 클릭 시 해당 상품을 cart에 추가
완료 후 router.push({ name: 'cart' })로 이동 -->
