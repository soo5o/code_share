<template>
  <div class="d-flex justify-content-center">
    <h4>상품 목록</h4>
    <div class="row">
      <div
        v-for="product in products"
        :key="product.id"
        class="col-md-3 d-flex"
      >
        <div class="card w-100 mt-5 rounded-2">
          <img :src="product.image" />
          <div class="text-center">{{ product.name }}</div>
          <div class="text-center">{{ product.price.toLocaleString() }}원</div>

          <router-link
            :to="{ name: 'products/id', params: { id: product.id } }"
            class="text-success text-center"
            >상세보기</router-link
          >
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import products from '@/data/products.json';
</script>
