<template>
  <div
    class="flex flex-col items-center justify-center min-h-screen max-w-md w-full mx-auto px-4"
  >
    <h2 class="font-bold text-4xl mb-10">Sign Up</h2>
    <div>
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

      <BaseInput
        v-model="form.password"
        type="password"
        placeholder="비밀번호"
      />

      <BaseInput
        v-model="form.password_check"
        type="password"
        placeholder="비밀번호 확인"
      />
      <BaseError
        v-if="form.password !== form.password_check && form.password_check"
        error
      >
        비밀번호가 일치하지 않습니다.
      </BaseError>

      <BaseInput v-model="form.name" type="text" placeholder="이름" />

      <BaseButton @click="handleSubmit">회원가입</BaseButton>
    </div>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import BaseError from "../components/base/BaseError.vue";
import { useRouter } from "vue-router";
import { useModalStore } from "../stores/modal";
import { useAuthApi } from "../api/auth";

const { signup, exists } = useAuthApi();
const router = useRouter();
const modalStore = useModalStore();

const form = reactive({
  email: "",
  password: "",
  password_check: "",
  name: "",
});

const ERROR_MSG = {
  EMPTY: "모든 값을 입력해주세요.",
  INVALID_EMAIL: "올바른 이메일 형식을 입력해주세요.",
  PASSWORD_MISMATCH: "비밀번호가 일치하지 않습니다.",
  EMAIL_EXISTS: "이미 가입된 이메일입니다.",
  SERVER: "서버 오류 발생",
  TRY_AGAIN: "다시 시도해주세요.",
  SUCCESS: "회원가입이 완료되었습니다.",
};

const isEmptyForm = (form) => {
  return !form.email || !form.password || !form.password_check || !form.name;
};

const isValidEmail = (email) => {
  return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(email);
};

const isPasswordMatch = (password, passwordCheck) => {
  return password === passwordCheck;
};

const openErrorModal = (type) => {
  modalStore.openModal({
    title: "회원가입 실패",
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
    if (!isPasswordMatch(form.password, form.password_check)) {
      return openErrorModal("PASSWORD_MISMATCH");
    }

    const exist = await exists(form.email);

    if (exist.data === false) {
      return openErrorModal("EMAIL_EXISTS");
    }

    const res = await signup(form.email, form.password, form.name);
    if (res.data) {
      modalStore.openModal({
        title: "회원가입 성공",
        message: ERROR_MSG.SUCCESS,
      });
      router.push("/");
    } else {
      openErrorModal("TRY_AGAIN");
    }
  } catch (err) {
    console.error(err);
    openErrorModal("SERVER");
  }
};
</script>
