// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore";
import { getStorage } from "firebase/storage";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyB4Vrxbz-SB1qeBGoYYEu04-NkBet0ZVD8",
    authDomain: "simpleweb-d235d.firebaseapp.com",
    projectId: "simpleweb-d235d",
    storageBucket: "simpleweb-d235d.appspot.com",
    messagingSenderId: "710843391575",
    appId: "1:710843391575:web:3e8035cc33f0cf0d470d12"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

const db = getFirestore(app) //데이터베이스
const auth = getAuth(app); //인증
const storage = getStorage(app); //스토리지

export {db, auth};