import { defineStore } from "pinia";

export const useThemeStore = defineStore("theme", {
  state: () => ({
    color: "orange",
  }),
  actions: {
    setColor(newColor) {
      this.color = newColor;
    },
  },
  persist: true,
});
