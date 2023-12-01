/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    fontFamily: {
      'montserrat': ['Montserrat', 'sans-serif']},
    colors:{
      "red-primary": '#BB2649',
      "beige-secondary": '#FFD6A5'
    },
    extend: {},
  },
  plugins: [],
}

