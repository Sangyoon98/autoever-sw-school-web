import firebase from "firebase/compat/app";
import "firebase/compat/storage";

const firebaseConfig = {
  apiKey: "AIzaSyAGNulxYa0nAokzEKpVI8Ee3X2D51Emkl8",
  authDomain: "photo-upload-fcdbb.firebaseapp.com",
  projectId: "photo-upload-fcdbb",
  storageBucket: "photo-upload-fcdbb.firebasestorage.app",
  messagingSenderId: "686749341696",
  appId: "1:686749341696:web:a36c8e616d68dc8235a0e5",
};

firebase.initializeApp(firebaseConfig);
export const storage = firebase.storage();
