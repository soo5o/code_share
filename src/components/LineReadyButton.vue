<template>
  <div class="container">
    <button
      @click="$emit('ready', { msg: `대사 준비 완료! (총 ${++n}회 눌림)` })"
    >
      대사 준비 완료
    </button>
    <div class="btnMsg">버튼 누른 횟수</div>
    <slot>Item</slot>
  </div>
</template>
<script>
export default {
  name: 'LineReadyButton',
  props: ['orders'],
  data() {
    return {
      n: 0,
    };
  },
  methods: {},
};
</script>
<!-- 
부모 컴포넌트에 ready라는 이름의 이벤트를 emit으로 전달
전달하는 메시지: 대사 준비 완료! (총 n회 눌림) (n = 클릭 횟수)
버튼 클릭 횟수를 화면에 버튼을 누른 횟수: n회 형식으로 표시
버튼 아래에는 slot을 사용해서 부모 컴포넌트가 작성하는 응원 멘트를 표시하세요.
slot 내용이 없으면 여기에 서윤이의 코멘트가 들어갑니다. 라는 기본 텍스트가 표시되도록 합니다.

가운데 정렬
slot으로 전달된 멘트는 연한 회색 카드 스타일로 표시하고, 카드 스타일은 아래와 같습니다:
배경색: #F1F2F6
테두리: 1px solid #DFE4EA
둥근 모서리, padding 14px, 최대 너비 400px -->
<style>
button {
  height: 40px;
  padding: 0 16px;
  color: white;
  background-color: #ff7675;
  border-radius: 12px;
  border: none;
}
button:hover {
  background-color: #d63031;
}
</style>
