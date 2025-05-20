import { defineStore } from "pinia";

export const useUserStore = defineStore("user", {
  state: () => ({
    email: "",
  }),
  actions: {
    setEmail(newEmail) {
      this.email = newEmail;
    },
  },
  persist: true,
});
