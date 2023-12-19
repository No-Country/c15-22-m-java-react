import { useEffect, useState } from "react";
import { getImageOfBase64 } from "../helpers/getImageOfBase64";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import Swal from "sweetalert2";
import { Link } from "react-router-dom";
const MyPetsCard = ({ pet }) => {
  const { onDeletePet, getPet } = useContactoMascota();
  const [currentImage, setCurrentImage] = useState("");

  const { name, race, state, id } = pet;

  let states = {
    ADOPTED: "Adoptado",
    ADOPTION: "Adopción",
    FOUND: "Encontrado",
    LOST: "Perdido",
  };

  useEffect(() => {
    const { images } = pet;

    getImageOfBase64(images[0].imageBase64, (imagen) => {
      setCurrentImage(imagen);
    });
  }, [pet]);

  const updatePet = (id) => {
    console.log(id);
    getPet(id);
  };

  const deletePet = (id) => {
    Swal.fire({
      title: "¿Estás seguro?",
      text: "No podrás revertir esto",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, eliminar",
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          "Eliminado",
          "Tu mascota reportada ha sido eliminado",
          "success"
        );
        onDeletePet(id);
      }
    });
  };

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
        <a href="#">
          <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white text-center">
            {name}
          </h5>
        </a>
        <p className="font-normal text-gray-700 dark:text-gray-400">
          Raza: {race}
        </p>
        <p className="font-normal text-gray-700 dark:text-gray-400">
          Estado: {states[state]}
        </p>
        <div className="flex justify-between text-white mt-4">
          <Link
            to={"/auth/actualizarmascota"}
            className="bg-yellow-400 p-2 rounded-md"
            onClick={() => updatePet(id)}
          >
            Actualizar
          </Link>
          <button
            type="button"
            className="bg-red-600 p-2 rounded-md"
            onClick={() => deletePet(id)}
          >
            Eliminar
          </button>
        </div>
      </div>
    </article>
  );
};

export default MyPetsCard;
