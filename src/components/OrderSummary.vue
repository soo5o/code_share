<template>
  <div class="container">
    <h2>💌 주문 내역서</h2>
    <div>주문 시간: {{ orderTime }}</div>
    <hr />
    <div>
      <p>음료: {{ drink.name }}</p>
      <p>사이즈: {{ optionData.size }}</p>
      <p>추가 샷: {{ optionData.extraShot ? '추가함' : '없음' }}</p>
      <p>얼음 양: {{ optionData.ice }}</p>
    </div>
    <hr />
    <div>결제 금액: {{ drink.price.toLocaleString() }}원</div>
    <button @click="confirmOrder({ drink, optionData })" class="orderBtn">
      주문 확정하기
    </button>
  </div>
</template>
<script>
export default {
  name: 'OrderSummary',
  props: ['drink', 'optionData'],
  methods: {
    confirmOrder(order) {
      this.$emit('place-order', order);
    },
  },
  computed: {
    orderTime() {
      return new Date().toLocaleString();
    },
  },
};
</script>
