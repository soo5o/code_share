<template>
  <h4 class="text-center mt-3">장바구니</h4>
  <div v-for="c of cart" class="carts mt-2">
    <div>
      <img :src="c.image" width="100px" height="100px" class="rounded-3" />
    </div>
    <div class="ms-2 info">
      <div>
        <strong>{{ c.name }}</strong>
      </div>
      <div>{{ c.price }}원</div>
    </div>
  </div>
  <div class="text-center">총합: {{ totalAmount().toLocaleString() }}원</div>
</template>
<script setup>
import { inject } from 'vue';
const state = inject('cartState');
const cart = state.cart;
const totalAmount = () => {
  return cart.reduce((acc, cur) => acc + parseInt(cur.price), 0);
};
</script>
<style>
.carts {
  display: flex;
}
.info {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
