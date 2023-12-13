/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
    'node_modules/flowbite-react/lib/esm/**/*.js'
    
  ],
  theme: {
    fontFamily: {
      'montserrat': ['Montserrat', 'sans-serif']
    },
    colors: {
      "red-primary": '#BB2649',
      "beige-secondary": '#FFD6A5'
    },
    extend: {},
  },
  plugins: [

    require('flowbite/plugin')
    // require('flowbite/plugin')

  ],
}


