<template>
  <h2>{{ selectedDrink.name }} 옵션 선택</h2>
  <div>
    사이즈:
    <br />
    <input
      type="radio"
      id="small"
      name="size"
      value="Small"
      @change="updateOptions"
    />
    <label for="small">Small</label>

    <input
      type="radio"
      id="medium"
      name="size"
      value="Medium"
      checked
      @change="updateOptions"
    />
    <label for="medium">Medium</label>

    <input
      type="radio"
      id="large"
      name="size"
      value="Large"
      @change="updateOptions"
    />
    <label for="large">Large</label>
  </div>

  <div>
    <input
      type="checkbox"
      id="extra-shot"
      name="extra-shot"
      @change="updateOptions"
    />
    <label for="extra-shot">샷 추가</label>
  </div>

  <div>
    얼음량:
    <select @change="updateOptions">
      <option value="적게">적게</option>
      <option value="보통" selected>보통</option>
      <option value="많이">많이</option>
    </select>
  </div>
</template>

<script>
export default {
  name: 'DrinkOptions',
  props: ['selectedDrink'],
  methods: {
    updateOptions() {
      const size = document.querySelector('input[name="size"]:checked')?.value;
      const extraShot = document.querySelector(
        'input[name="extra-shot"]'
      )?.checked;
      const ice = document.querySelector('select')?.value;

      this.$emit('options-changed', { size, extraShot, ice });
    },
  },
};
</script>
