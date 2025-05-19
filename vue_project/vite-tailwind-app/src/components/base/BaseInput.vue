<template>
  <input
    :type="type"
    :placeholder="placeholder"
    :value="modelValue"
    class="w-full p-4 mt-4 border border-gray-300 rounded-full focus:outline-none focus:border-blue-500"
    @input="$emit('update:modelValue', $event.target.value)"
  />
</template>

<script setup>
defineProps({
  type: {
    type: String,
    default: "text",
  },
  placeholder: {
    type: String,
    default: "",
  },
  modelValue: {
    type: String,
    required: true,
  },
});
</script>
