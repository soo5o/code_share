<template>
  <button
    v-for="menu in menus"
    :key="menu.name"
    class="btn"
    @click="selectDrink(menu)"
  >
    {{ menu.name }} ({{ menu.price }}원)
  </button>
</template>
<script>
export default {
  name: 'MenuList',
  props: ['menus'],
  methods: {
    selectDrink(menu) {
      this.$emit('select-drink', menu);
    },
  },
};
</script>
