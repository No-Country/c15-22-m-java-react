import { useEffect, useState } from "react";
import { getImageOfBase64 } from "../helpers/getImageOfBase64";
import { Link } from "react-router-dom";

export const LastPetsCards = ({ pet }) => {
  const [currentImage, setCurrentImage] = useState("");

  const { name, race, state, id } = pet;

  useEffect(() => {
    const {
      image: { imageBase64 },
    } = pet;

    getImageOfBase64(imageBase64, (imagen) => {
      setCurrentImage(imagen);
    });
  }, [pet]);

  return (
    <Link
      to={`/mascota/${id}`}
      className="block max-w-sm m-0 p-0 bg-white border border-gray-200 rounded-lg shadow hover:bg-orange-200 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700"
    >
      {currentImage && (
        <img
          src={currentImage}
          alt={name}
          width="300"
          height="300"
          className="w-full object-cover object-center h-96 rounded-tr-md rounded-tl-md"
        />
      )}
      <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white text-center">
        {name}
      </h5>
      <p className="font-normal text-gray-700 dark:text-gray-400 text-center">
        Raza: {race}
      </p>
    </Link>
  );
};
