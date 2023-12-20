import { useEffect, useState } from "react";
import { getImageOfBase64 } from "../helpers/getImageOfBase64";
import { useContactoMascota } from "../../hooks/useContactoMascota";
import Swal from "sweetalert2";
import { Link } from "react-router-dom";
const MyPetsCard = ({ pet }) => {
  const { onDeletePet, getPet, setImagePet } = useContactoMascota();
  const [currentImage, setCurrentImage] = useState("");
  const { images } = pet;

  const { name, race, state, id } = pet;

  let states = {
    ADOPTED: "Adoptado",
    ADOPTION: "Adopción",
    FOUND: "Encontrado",
    LOST: "Perdido",
  };

  useEffect(() => {
    getImageOfBase64(images[0].imageBase64, (imagen) => {
      setCurrentImage(imagen);
    });
  }, [pet]);

  const updatePet = (id) => {
    setImagePet(images[0]);
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
        <div className="flex justify-between items-center mt-2">
          <div className="flex">
            <Link to={`/mascota/${id}`} className="bg-blue-400 p-2 rounded-md">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="1em"
                height="1em"
                viewBox="0 0 24 24"
              >
                <path
                  fill="currentColor"
                  d="M12 9a3 3 0 0 0-3 3a3 3 0 0 0 3 3a3 3 0 0 0 3-3a3 3 0 0 0-3-3m0 8a5 5 0 0 1-5-5a5 5 0 0 1 5-5a5 5 0 0 1 5 5a5 5 0 0 1-5 5m0-12.5C7 4.5 2.73 7.61 1 12c1.73 4.39 6 7.5 11 7.5s9.27-3.11 11-7.5c-1.73-4.39-6-7.5-11-7.5"
                />
              </svg>
            </Link>
          </div>
          <div className="flex gap-1">
            <Link
              to={"/auth/actualizarmascota"}
              className="bg-yellow-400 p-2 rounded-md"
              onClick={() => updatePet(id)}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="1em"
                height="1em"
                viewBox="0 0 24 24"
              >
                <path
                  fill="currentColor"
                  d="M3 21v-4.25L16.2 3.575q.3-.275.663-.425t.762-.15q.4 0 .775.15t.65.45L20.425 5q.3.275.438.65T21 6.4q0 .4-.137.763t-.438.662L7.25 21zM17.6 7.8L19 6.4L17.6 5l-1.4 1.4z"
                />
              </svg>
            </Link>
            <button
              type="button"
              className="bg-red-600 p-2 rounded-md"
              onClick={() => deletePet(id)}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="1em"
                height="1em"
                viewBox="0 0 24 24"
              >
                <path
                  fill="currentColor"
                  d="M9 3v1H4v2h1v13a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V6h1V4h-5V3zm0 5h2v9H9zm4 0h2v9h-2z"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>
    </article>
  );
};

export default MyPetsCard;
