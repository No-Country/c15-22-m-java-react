import { useEffect, useState } from "react";
import { getImageOfBase64 } from "../helpers/getImageOfBase64";

export const ShowPetById = ({ pet }) => {
  const [currentImage, setCurrentImage] = useState("");
  const { age, description, name, race, state, type } = pet;
  const {
    user: { name: owner, lastname, phone, email },
  } = pet;

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
    <section className="max-w-[1200px] mx-auto grid grid-cols-1 gap-4 justify-center items-start md:grid-cols-2">
      {currentImage && (
        <img
          className="object-cover w-full h-auto"
          src={currentImage}
          alt=""
        />
      )}
      <div className="flex flex-col justify-start gap-4 p-4 leading-normal">
        <h1 className="text-3xl md:text-5xl font-bold text-center py-6">
          {name}
        </h1>

        <div>
          <h2 className="mb-2 text-lg font-semibold text-gray-900 dark:text-white">
            Características:
          </h2>

          <ul className="max-w-md space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400">
            <li>Edad: {age} años</li>
            <li>Descripción: {description}</li>
            <li>Raza: {race}</li>
            <li>
              Estado: <span className="font-semibold">{states[state]}</span>
            </li>
            <li>Tipo: {type}</li>
          </ul>
        </div>

        <div>
          <h2 className="mb-2 text-lg font-semibold text-gray-900 dark:text-white">
            Propietario:
          </h2>

          <ul className="max-w-md space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400">
            <li>
              {owner} {lastname}
            </li>
            <li>Teléfono: {phone}</li>
            <li>Email: {email}</li>
          </ul>
        </div>
      </div>
    </section>
  );
};
