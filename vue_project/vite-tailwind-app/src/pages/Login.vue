<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen max-w-md w-full mx-auto px-4"
  >
    <h1 class="text-2xl font-bold mb-4">로그인</h1>
    <BaseInput v-model="form.email" type="email" placeholder="이메일" />
    <BaseError
      v-if="
        form.email &&
        !/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(form.email)
      "
      error
    >
      올바른 이메일 형식을 입력해주세요.
    </BaseError>

    <BaseInput v-model="form.password" type="password" placeholder="비밀번호" />

    <BaseButton @click="handleSubmit">로그인</BaseButton>

    <div class="flex mt-4">
      <p>비밀번호를 잊으셨나요?</p>
      <router-link to="/signup" class="text-blue-500 hover:underline ml-2">
        회원가입
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from "vue";
import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import BaseError from "../components/base/BaseError.vue";
import { useRouter } from "vue-router";
import { useUserStore } from "../stores/user";
import { useModalStore } from "../stores/modal";
import { useAuthApi } from "../api/auth";

const { login } = useAuthApi();
const router = useRouter();

const userStore = useUserStore();
const modalStore = useModalStore();

const form = reactive({
  email: "",
  password: "",
});

const ERROR_MSG = {
  EMPTY: "모든 값을 입력해주세요.",
  INVALID_EMAIL: "올바른 이메일 형식을 입력해주세요.",
  SERVER: "서버 오류 발생",
  LOGIN_FAIL: "이메일 또는 비밀번호를 확인해주세요.",
};

const isEmptyForm = (form) => {
  return !form.email || !form.password;
};

const isValidEmail = (email) => {
  return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email);
};

const openErrorModal = (type) => {
  modalStore.openModal({
    title: "로그인 실패",
    message: ERROR_MSG[type],
  });
};

const handleSubmit = async () => {
  try {
    if (isEmptyForm(form)) {
      return openErrorModal("EMPTY");
    }
    if (!isValidEmail(form.email)) {
      return openErrorModal("INVALID_EMAIL");
    }

    const res = await login(form.email, form.password);
    if (res.data) {
      localStorage.setItem("isLogin", "TRUE");
      userStore.setEmail(form.email);
      router.push("/home");
    } else {
      openErrorModal("LOGIN_FAIL");
    }
  } catch (err) {
    console.error(err);
    openErrorModal("SERVER");
  }
};
</script>
