import { defineStore } from "pinia";

export const useModalStore = defineStore("modal", {
  state: () => ({
    isOpen: false,
    title: "",
    message: "",
    hasCancel: false,
    confirmCallback: null,
  }),
  actions: {
    open({ title, message, hasCancel = false, onConfirm = null }) {
      this.title = title;
      this.message = message;
      this.hasCancel = hasCancel;
      this.confirmCallback = onConfirm;
      this.isOpen = true;
    },
    confirm() {
      if (this.confirmCallback) this.confirmCallback();
      this.close();
    },
    close() {
      this.isOpen = false;
      this.confirmCallback = null;
    },
  },
});
