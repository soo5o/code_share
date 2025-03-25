<template>
  <div class="container">
    <h2>📊 주문 통계</h2>
    <div>총 주문 횟수: {{ orders.length }}회</div>
    <div>총 매출: {{ getTotalAmount }}원</div>
    <div>가장 인기 있는 음료: {{ getPopularDrinkName }} ({{ mxCount }}회)</div>
    <div>가장 많이 선택된 사이즈: {{ getPopularSize }}</div>
    <div>추가 샷 비율: {{ getExtraShotRatio }}%</div>
  </div>
</template>
<script>
export default {
  name: 'Statistics',
  props: ['orders'],
  data() {
    return { popularDrink: {}, mxCount: 0 };
  },
  computed: {
    getTotalAmount() {
      return this.orders.reduce((acc, order) => acc + order.price, 0);
    },
    getPopularDrinkName() {
      const popularDrink = this.getPopularDrink();
      const maxCount = Math.max(...Object.values(popularDrink));
      this.mxCount = maxCount;
      return Object.keys(popularDrink).find(
        (name) => popularDrink[name] === maxCount
      );
    },
    getPopularSize() {
      const popularDrink = this.getPopularSizes();
      const maxCount = Math.max(...Object.values(popularDrink));
      return Object.keys(popularDrink).find(
        (size) => popularDrink[size] === maxCount
      );
    },
    getExtraShotRatio() {
      const extraShotOrders = this.orders.filter((order) => order.extraShot);
      return Math.round((extraShotOrders.length / this.orders.length) * 100);
    },
  },
  methods: {
    getPopularDrink() {
      const drinkCount = {};
      this.orders.forEach((order) => {
        if (drinkCount[order.drinkName]) {
          drinkCount[order.drinkName]++;
        } else {
          drinkCount[order.drinkName] = 1;
        }
      });
      return drinkCount;
    },
    getPopularSizes() {
      const drinkCount = {};
      this.orders.forEach((order) => {
        if (drinkCount[order.size]) {
          drinkCount[order.size]++;
        } else {
          drinkCount[order.size] = 1;
        }
      });
      return drinkCount;
    },
  },
};
</script>
