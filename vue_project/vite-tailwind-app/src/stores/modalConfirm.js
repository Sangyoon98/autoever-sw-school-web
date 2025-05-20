import { defineStore } from "pinia";
import { ref } from "vue";

export const useModalConfirmStore = defineStore("modalConfirm", () => {
  const show = ref(false);
  const title = ref("");
  const message = ref("");
  const confirmCallback = ref(null);
  const cancelCallback = ref(null);

  // 모달을 여는 함수
  function openModal({
    title: newTitle,
    message: newMessage,
    onConfirm,
    onCancel,
  }) {
    title.value = newTitle;
    message.value = newMessage;
    confirmCallback.value = onConfirm;
    cancelCallback.value = onCancel;
    show.value = true;
  }

  // 모달을 닫는 함수
  function cancelModal() {
    show.value = false;
    title.value = "";
    message.value = "";
    cancelCallback.value?.();
  }

  // 모달의 확인 함수
  function confirmModal() {
    show.value = false;
    title.value = "";
    message.value = "";
    confirmCallback.value?.();
  }

  return {
    show,
    title,
    message,
    openModal,
    cancelModal,
    confirmModal,
    confirmCallback,
    cancelCallback,
  };
});
