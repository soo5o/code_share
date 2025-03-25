<template>
  <div class="container">
    <div v-for="order in orders" :key="order.time">
      <div>
        <div>🕑 {{ order.time }}</div>
        <div>음료: {{ order.drinkName }}</div>
        <div>사이즈: {{ order.size }}</div>
        <div>샷 추가: {{ order.extraShot ? '추가함' : '추가 안 함' }}</div>
        <div>얼음량: {{ order.ice }}</div>
        <div>금액: {{ order.price }}</div>
        <hr />
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'OrderHistory',
  props: ['orders'],
};
</script>
