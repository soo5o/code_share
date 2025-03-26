<template>
  <div
    class="container d-flex flex-column align-items-center justify-content-center"
  >
    <h1>improv-acting-lab 🦹🏻‍♀️</h1>
    <LineReadyButton @ready="handleReady"
      ><div class="card"></div
    ></LineReadyButton>
  </div>
</template>
<script>
import LineReadyButton from './components/LineReadyButton.vue';
export default {
  name: 'App',
  components: {
    LineReadyButton,
  },
  data() {
    return {};
  },
  methods: {
    handleReady() {
      console.log('대사 준비 완료!');
    },
  },
};
</script>
<!-- :흰색_확인_표시: 부모 컴포넌트(App.vue) 요구사항
LineReadyButton 컴포넌트를 가져와 사용하세요.
@ready 이벤트를 받아 콘솔에 메시지를 출력하도록 handleReady 메서드를 작성하세요.
slot으로 "오늘도 넌 멋질 거야! :마이크: 자신 있게 무대에 올라가!" 와 같은 응원 멘트를 전달하세요. -->
<!-- 오늘도 넌 멋질 거야! :마이크: 자신 있게 무대에 올라가! -->
<style>
.card {
  background-color: #f1f2f6;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  padding: 14px;
  max-width: 400px;
}
</style>
