import { useState } from "react";
import useForm from "../hooks/useForm";
import { toBase64 } from "../helpers/toBase64";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import toast, { Toaster } from "react-hot-toast";
import { useNavigate } from "react-router-dom";

export const FormLostPet = () => {
  const { reportPet, user } = useContactoMascota();
  const [fileInputValue, setFileInputValue] = useState("");
  let {
    formState: { name, description, type, race, age, state, image },
    formState,
    onInputChange,
    onResetForm,
  } = useForm({
    name: "",
    description: "",
    type: "",
    race: "",
    age: "",
    state: "",
    image: "",
    user_id: "",
  });

  const navigate = useNavigate("");

  const handleFileInputChange = (event) => {
    const file = event.target.files[0];
    setFileInputValue(file);
  };

  const onClose = (t) => {
    toast.dismiss(t.id);
    navigate("/auth/dashboard");
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (description.length < 10 || description > 10000) {
      toast.error("La descripción debe tener de 10 a 10000 caracteres", {
        duration: 4000,
      });
      return;
    }

    formState.user_id = Number(user.id);

    toBase64(fileInputValue, (base64String) => {
      formState.image = base64String;
      reportPet(formState);
    });

    toast.custom((t) => (
      <div
        className={`${
          t.visible ? "animate-enter" : "animate-leave"
        } max-w-md w-full bg-white shadow-lg rounded-lg pointer-events-auto flex ring-1 ring-black ring-opacity-5`}
      >
        <div className="flex-1 w-0 p-4">
          <div className="flex items-start">
            <div className="ml-3 flex-1">
              <p className="text-sm font-medium text-gray-900">
                Mascota reportada
              </p>
              <p className="mt-1 text-sm text-gray-500">Gracias por reportar</p>
            </div>
          </div>
        </div>
        <div className="flex border-l border-gray-200">
          <button
            onClick={() => onClose(t)}
            className="w-full border border-transparent rounded-none rounded-r-lg p-4 flex items-center justify-center text-sm font-medium text-indigo-600 hover:text-indigo-500 focus:outline-none focus:ring-2 focus:ring-indigo-500"
          >
            Close
          </button>
        </div>
      </div>
    ));
    onResetForm();
  };

  return (
    <form className="max-w-lg mx-auto" onSubmit={handleSubmit}>
      <Toaster position="top-center" reverseOrder={false} />
      <div className="mb-5">
        <label
          htmlFor="email"
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >
          Nombre de la mascota
        </label>
        <input
          type="text"
          name="name"
          id="name_id"
          value={name}
          onChange={onInputChange}
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-300 focus:border-orange-400 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-orange-300 dark:focus:border-orange-300"
          required
        />
      </div>
      <div className="mb-5">
        <label
          htmlFor="email"
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >
          Descripción
        </label>
        <textarea
          name="description"
          id="description_id"
          value={description}
          onChange={onInputChange}
          cols="30"
          rows="10"
          required
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-300 focus:border-orange-400 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-orange-300 dark:focus:border-orange-300"
        ></textarea>
      </div>

      <div className="mb-5">
        <label
          htmlFor="email"
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >
          Especie
        </label>

        <select
          id="type_id"
          name="type"
          value={type}
          onChange={onInputChange}
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
          required
        >
          <option value="">Elige la Especie</option>
          <option value="Perro">Perro</option>
          <option value="Gato">Gato</option>
          <option value="Otro">Otro</option>
        </select>
      </div>
      <div className="mb-5">
        <label
          htmlFor="email"
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >
          Raza
        </label>
        <input
          type="text"
          name="race"
          id="race_id"
          value={race}
          onChange={onInputChange}
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-300 focus:border-orange-400 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-orange-300 dark:focus:border-orange-300"
          required
        />
      </div>
      <div className="mb-5">
        <label
          htmlFor="email"
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >
          Edad
        </label>
        <input
          type="number"
          min="0"
          name="age"
          id="age_id"
          value={age}
          onChange={onInputChange}
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-orange-300 focus:border-orange-400 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-orange-300 dark:focus:border-orange-300"
          required
        />
      </div>
      <div className="mb-5">
        <label
          htmlFor="countries"
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
        >
          Estado
        </label>

        <select
          id="countries"
          name="state"
          value={state}
          onChange={onInputChange}
          className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
          required
        >
          <option value="">Elige el estado</option>
          <option value="ADOPTION">Adopción</option>
          <option value="FOUND">Encontrado</option>
          <option value="LOST">Perdido</option>
        </select>
      </div>
      <div className="mb-5">
        <label
          className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
          htmlFor="file_input"
        >
          Subir imagen de la mascota
        </label>
        <input
          className="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400"
          aria-describedby="file_input_help"
          id="file_input"
          type="file"
          accept=".jpg, .png, .svg"
          name="image"
          onChange={handleFileInputChange}
          required
        />
        <p
          className="mt-1 text-sm text-gray-500 dark:text-gray-300"
          id="file_input_help"
        >
          SVG, PNG, JPG (MAX. 800x400px).
        </p>
      </div>

      <button
        type="submit"
        className="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800"
      >
        Reportar
      </button>
    </form>
  );
};
