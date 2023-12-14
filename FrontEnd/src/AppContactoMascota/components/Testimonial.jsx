const Testimonial = () => {
  return (
    <section className="p-6">
      <h2 className="text-3xl md:text-5xl font-bold text-center my-5">
        Historias con finales felices
      </h2>
      <div className="container max-w-xl mx-auto">
        <div className="flex flex-col items-center w-full p-6 space-y-8 rounded-md lg:h-full lg:p-8 dark:bg-gray-900 dark:text-gray-100">
          <img
            src="https://source.unsplash.com/random/100x100?4"
            alt=""
            className="w-20 h-20 rounded-full dark:bg-gray-500"
          />
          <blockquote className="max-w-lg text-lg italic font-medium text-center">
            "Feliz de tener esta web que unifica las busquedas de las mascotas y
            gracias a eso me pude reencontrar con mi perrito. Gracias!"
          </blockquote>
          <div className="text-center dark:text-gray-400">
            <p>nombre propietario</p>
            <p>Nombre mascota</p>
          </div>
          <div className="flex space-x-2">
            <button
              type="button"
              aria-label="Page 1"
              className="w-2 h-2 rounded-full dark:bg-gray-50"
            ></button>
            <button
              type="button"
              aria-label="Page 2"
              className="w-2 h-2 rounded-full dark:bg-gray-600"
            ></button>
            <button
              type="button"
              aria-label="Page 3"
              className="w-2 h-2 rounded-full dark:bg-gray-600"
            ></button>
            <button
              type="button"
              aria-label="Page 4"
              className="w-2 h-2 rounded-full dark:bg-gray-600"
            ></button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Testimonial;
