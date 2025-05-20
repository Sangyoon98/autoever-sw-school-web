import { defineStore } from "pinia";
import { ref } from "vue";

export const useModalStore = defineStore("modal", () => {
  const show = ref(false);
  const title = ref("");
  const message = ref("");

  // 모달을 여는 함수
  function openModal({ title: newTitle, message: newMessage }) {
    title.value = newTitle;
    message.value = newMessage;
    show.value = true;
  }

  // 모달을 닫는 함수
  function closeModal() {
    show.value = false; 
    title.value = "";
    message.value = "";
  }

  return { show, title, message, openModal, closeModal };
});
