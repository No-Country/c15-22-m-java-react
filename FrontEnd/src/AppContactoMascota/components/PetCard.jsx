import { useEffect, useState } from "react";
import { getImageOfBase64 } from "../helpers/getImageOfBase64";
import { Link } from "react-router-dom";
const PetCard = ({ pet }) => {
  const [currentImage, setCurrentImage] = useState("");
  const { name, race, state, id } = pet;

  let states = {
    ADOPTED: "Adoptado",
    ADOPTION: "Adopción",
    FOUND: "Encontrado",
    LOST: "Perdido",
  };

  useEffect(() => {
    const {
      image: { imageBase64 },
    } = pet;

    getImageOfBase64(imageBase64, (imagen) => {
      setCurrentImage(imagen);
    });
  }, [pet]);

  return (
    <article className="max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-400 hover:scale-105 transition-all">
      {currentImage && (
        <img
          src={currentImage}
          alt={pet.name}
          width="300"
          height="300"
          className="object-cover object-center h-60 rounded-tr-md rounded-tl-md w-full"
        />
      )}
      <div className="p-5">
        <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white text-center">
          {name}
        </h5>

        <p className="font-normal text-gray-700 dark:text-gray-400">
          Raza: {race}
        </p>
        <p className="font-normal text-gray-700 dark:text-gray-400">
          Estado: {states[state]}
        </p>
        <Link
          to={`/mascota/${id}`}
          className="my-2 inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-orange-400 rounded-lg hover:bg-orange-500 focus:ring-4 focus:outline-none focus:ring-orange-300 dark:bg-orange-600 dark:hover:bg-orange-400 dark:focus:ring-orange-800"
        >
          Leer más
          <svg
            className="rtl:rotate-180 w-3.5 h-3.5 ms-2"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 14 10"
          >
            <path
              stroke="currentColor"
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth="2"
              d="M1 5h12m0 0L9 1m4 4L9 9"
            />
          </svg>
        </Link>
      </div>
    </article>
  );
};

export default PetCard;
