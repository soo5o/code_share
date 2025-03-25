<template>
  <div class="container">
    <h1>카페 주문 앱</h1>
    <h2>메뉴 선택</h2>
    <MenuList :menus="menuList" @select-drink="selectDrink" />
    <div v-if="selectedDrink" class="selected-drink">
      선택한 음료: {{ selectedDrink.name }} ({{ selectedDrink.price }}원)
    </div>
    <div v-if="selectedDrink" class="select-options">
      <DrinkOptions
        :selectedDrink="selectedDrink"
        @options-changed="optionsChanged"
      />
    </div>

    <div v-if="selectedDrink" class="options-changed">
      <h3>현재 선택 옵션</h3>
      <p>사이즈: {{ selectedOptions.size }}</p>
      <p>샷 추가: {{ selectedOptions.extraShot ? '추가함' : '추가 안 함' }}</p>
      <p>얼음량: {{ selectedOptions.ice }}</p>
    </div>
    <div v-if="selectedDrink && selectedOptions" class="order-summary">
      <OrderSummary
        :drink="selectedDrink"
        :optionData="selectedOptions"
        @place-order="handlePlaceOrder"
      />
    </div>
    <div class="order-history">
      <h2>✔ 주문 내역</h2>
      <div v-if="!orderHistory.length">주문 내역이 없습니다.</div>
      <OrderHistory :orders="orderHistory" />
    </div>
    <button
      v-if="orderHistory.length > 0"
      @click="changeStats"
      class="stats-btn"
    >
      {{ msg }}
    </button>
    <div class="order-statistics" v-if="showStats">
      <Statistics :orders="orderHistory" />
    </div>
  </div>
</template>

<script>
import MenuList from './components/MenuList.vue';
import DrinkOptions from './components/DrinkOptions.vue';
import OrderSummary from './components/OrderSummary.vue';
import OrderHistory from './components/OrderHistory.vue';
import Statistics from './components/Statistics.vue';
export default {
  name: 'App',
  components: {
    MenuList,
    DrinkOptions,
    OrderSummary,
    OrderHistory,
    Statistics,
  },
  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
      selectedDrink: null,
      selectedOptions: {
        size: 'Medium', // 기본값
        extraShot: false,
        ice: '보통',
      },
      orderHistory: [],
      showStats: false,
      msg: '통계보기',
    };
  },
  methods: {
    selectDrink(drink) {
      this.selectedDrink = drink; // 선택한 메뉴 객체 저장
      this.selectedOptions = {
        size: 'Medium',
        extraShot: false,
        ice: '보통',
      };
    },
    optionsChanged(options) {
      this.selectedOptions = options;
    },
    submitOrder() {
      alert(`[${this.selectedDrink.name}] 주문이 완료되었습니다!`);
      this.selectedDrink = null;
      this.selectedOptions = {
        size: 'Medium',
        extraShot: false,
        ice: '보통',
      };
    },
    handlePlaceOrder() {
      alert(`[${this.selectedDrink.name}] 주문이 완료되었습니다!`);
      this.orderHistory.unshift({
        time: new Date().toLocaleString(),
        drinkName: this.selectedDrink.name,
        size: this.selectedOptions.size,
        extraShot: this.selectedOptions.extraShot,
        ice: this.selectedOptions.ice,
        price: this.selectedDrink.price,
      });
      console.log(this.orderHistory);
      this.selectedDrink = null;
      this.selectedOptions = {
        size: 'Medium',
        extraShot: false,
        ice: '보통',
      };
    },
    changeStats() {
      this.showStats = !this.showStats;
      this.msg = this.showStats ? '통계 숨기기' : '통계 보기';
    },
  },
};
</script>
<!-- orderHistory 배열을 props로 Statistics 컴포넌트에 전달하도록 준비하세요.
주문 내역이 하나 이상(orderHistory.length > 0)일 때만 버튼이 나타나도록 구현하세요.
버튼에는 조건에 따라 통계 보기 또는 통계 숨기기 라는 텍스트가 표시되도록 합니다.
버튼 클릭 시 showStats 라는 불리언 변수를 true/false로 토글하세요.
showStats가 true일 때만 Statistics 컴포넌트가 렌더링되도록 합니다. -->
