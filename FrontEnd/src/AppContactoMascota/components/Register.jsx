import React from "react";
import Layout from "../../ui/Layout";
import { axiosMascota } from "../../config/axios.config";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const Register = () => {
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = Object.fromEntries(new FormData(e.target));
    data.rol = "USER";
    console.log(data);

    axiosMascota
      .post("/auth/registro", data)
      .then(() => {
        alert("usuario creado correctamente, ahora pasa al login");
        navigate("/auth/login");
      })
      .catch((err) => console.log(err));
  };

  return (
    <Layout>
      <div className="container mx-auto h-full p-10 ">
        <div className=" g-6 flex h-full border-beige-secondary shadow-ml flex-wrap items-center justify-center text-neutral-800 dark:text-neutral-200">
          <div className="w-full">
            <div className="block  rounded-lg bg-white shadow-lg dark:bg-neutral-800">
              <div className="g-0 lg:flex lg:flex-wrap ">
                {/* <!-- Left column container--> */}
                <div className="px-4 md:px-0 lg:w-6/12  mt-5">
                  <div className="md:mx-6 md:p-12">
                    {/* <!--Logo--> */}
                    <div className="text-center">
                      {/* <img
                          className="mx-auto w-20 mt-8"
                          src="/images/logoRed.png"
                          alt="logo"
                        /> */}
                      <h4 className="mb-8 mt-1 pb-1 text-2xl font-semibold">
                        Bienvenido
                      </h4>
                    </div>
                    {/* <div className="flex justify-between mx-5 gap-5">
                        <button className="flex flex-wrap justify-center w-full border border-gray-300 hover:border-gray-500 px-2 py-1.5 rounded-md">
                          <img
                            className="w-5 mr-2"
                            src="https://lh3.googleusercontent.com/COxitqgJr1sJnIDe8-jiKhxDx1FrYbtRHKJ9z_hELisAlapwE9LUPh6fcXIfb5vwpbMl4xl9H9TRFPc5NOO8Sb3VSgIBrfRYvW6cUA"
                          />
                          Registrar con Google
                        </button>

                        <button className="flex flex-wrap justify-center w-full border border-gray-300 hover:border-gray-500 px-2 py-1.5 rounded-md">
                          <img
                            className="w-5 mr-2"
                            src="/images/facebook.png"
                          />
                          Registrar con Facebook
                        </button>
                      </div> */}
                    <p className="mx-auto flex my-4 justify-center">
                      Ingresa tus datos
                    </p>

                    <form onSubmit={handleSubmit} className=" mx-5">
                      <div className="grid  mb-4">
                        <label htmlFor="">Nombre</label>
                        <input
                          type="text"
                          id="nombre"
                          label="Username"
                          className="mb-4 border rounded-md"
                          name="name"
                        ></input>
                      </div>
                      <div className="grid  mb-4">
                        <label htmlFor="">Apellido</label>
                        <input
                          type="text"
                          id="nombre"
                          label="Username"
                          className="mb-4 border rounded-md"
                          name="lastName"
                        ></input>
                      </div>
                      <div className="grid  mb-4">
                        <label htmlFor="">Teléfono</label>
                        <input
                          type="text"
                          label="Username"
                          className="mb-4 border rounded-md"
                          name="phone"
                        ></input>
                      </div>
                      <div className="grid  mb-4">
                        <label htmlFor="">Correo</label>
                        <input
                          type="email"
                          label="email"
                          className="mb-4 border rounded-md"
                          name="email"
                          id="email"
                        ></input>
                      </div>
                      {/* <div className="grid  mb-4">
                          <label htmlFor="">rol</label>
                          <input
                            type="text"
                            label="Username"
                            className="mb-4 border rounded-md"
                            name="rol"
                            id="rol"
                          ></input>
                        </div> */}

                      {/* <!--Password input--> */}
                      <div className="grid  mb-2">
                        <label htmlFor="">Contraseña</label>
                        <input
                          type="password"
                          label="Password"
                          className="mb-4 border rounded-md"
                          name="password"
                          id="password"
                        ></input>
                      </div>
                      {/* <div className="grid  mb-2">
                        <label htmlFor="">Confirmar Contraseña</label>
                        <input
                          type="password"
                         
                          label="Password"
                          className="mb-4 border rounded-md"
                          name='confirmPassword'
                        ></input>
                      </div> */}
                      <div className="mb-6 flex items-center justify-between">
                        {/* <!-- Remember me checkbox --> */}
                        <div className="mb-[0.125rem] block min-h-[1.5rem] pl-[1.5rem]">
                          <input
                            className="relative float-left -ml-[1.5rem] mr-[6px] mt-[0.15rem] h-[1.125rem] w-[1.125rem] appearance-none rounded-[0.25rem] border-[0.125rem] border-solid border-neutral-300 outline-none before:pointer-events-none before:absolute before:h-[0.875rem] before:w-[0.875rem] before:scale-0 before:rounded-full before:bg-transparent before:opacity-0 before:shadow-[0px_0px_0px_13px_transparent] before:content-[''] checked:border-primary checked:bg-primary checked:before:opacity-[0.16] checked:after:absolute checked:after:-mt-px checked:after:ml-[0.25rem] checked:after:block checked:after:h-[0.8125rem] checked:after:w-[0.375rem] checked:after:rotate-45 checked:after:border-[0.125rem] checked:after:border-l-0 checked:after:border-t-0 checked:after:border-solid checked:after:border-white checked:after:bg-transparent checked:after:content-[''] hover:cursor-pointer hover:before:opacity-[0.04] hover:before:shadow-[0px_0px_0px_13px_rgba(0,0,0,0.6)] focus:shadow-none focus:transition-[border-color_0.2s] focus:before:scale-100 focus:before:opacity-[0.12] focus:before:shadow-[0px_0px_0px_13px_rgba(0,0,0,0.6)] focus:before:transition-[box-shadow_0.2s,transform_0.2s] focus:after:absolute focus:after:z-[1] focus:after:block focus:after:h-[0.875rem] focus:after:w-[0.875rem] focus:after:rounded-[0.125rem] focus:after:content-[''] checked:focus:before:scale-100 checked:focus:before:shadow-[0px_0px_0px_13px_#3b71ca] checked:focus:before:transition-[box-shadow_0.2s,transform_0.2s] checked:focus:after:-mt-px checked:focus:after:ml-[0.25rem] checked:focus:after:h-[0.8125rem] checked:focus:after:w-[0.375rem] checked:focus:after:rotate-45 checked:focus:after:rounded-none checked:focus:after:border-[0.125rem] checked:focus:after:border-l-0 checked:focus:after:border-t-0 checked:focus:after:border-solid checked:focus:after:border-white checked:focus:after:bg-transparent dark:border-neutral-600 dark:checked:border-primary dark:checked:bg-primary dark:focus:before:shadow-[0px_0px_0px_13px_rgba(255,255,255,0.4)] dark:checked:focus:before:shadow-[0px_0px_0px_13px_#3b71ca]"
                            type="checkbox"
                            value=""
                            id="exampleCheck2"
                          />
                          <label
                            className="inline-block pl-[0.15rem] hover:cursor-pointer"
                            htmlFor="exampleCheck2"
                          >
                            Recordarme
                          </label>
                        </div>

                        {/* <!--Forgot password link--> */}
                        {/* <a href="#!">¿Has olvidado tu contraseña?</a> */}
                      </div>

                      {/* <!--Submit button--> */}
                      <div className="mb-6 pb-1 pt-1 text-center">
                        <button
                          className="mb-3 inline-block w-full rounded px-6 pb-2 pt-2.5 text-xs font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_rgba(0,0,0,0.2)] transition duration-150 ease-in-out hover:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)] focus:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)] focus:outline-none focus:ring-0 active:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)]"
                          // type="button"
                          style={{
                            background:
                              "linear-gradient(to right, #BB2649, #F35D74, #FFC3D4, #BB2649 )",
                            // "linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593)",
                          }}
                        >
                          Registrar
                        </button>
                      </div>

                      <div className="flex items-center justify-between">
                        <p className="mb-0 mr-2">¿Ya tienes cuenta?</p>
                        <Link
                          to={"/auth/login"}
                          className="bg-[#FFD6A5] inline-block rounded  border-danger px-6 pb-[6px] pt-2 text-xs font-medium uppercase leading-normal text-danger transition duration-150 ease-in-out hover:border-danger-600 hover:bg-neutral-500 hover:bg-opacity-10 hover:text-danger-600 focus:border-danger-600 focus:text-danger-600 focus:outline-none focus:ring-0 active:border-danger-700 active:text-danger-700 dark:hover:bg-neutral-100 dark:hover:bg-opacity-10"
                        >
                          Ingresar
                        </Link>
                      </div>
                    </form>
                  </div>
                </div>

                {/* <!-- Right column container with background and description--> */}

                <div
                  className="flex justify-center flex-col items-center rounded-b-lg lg:w-6/12 lg:rounded-r-lg lg:rounded-bl-none mt-9"
                  style={
                    {
                      // background:
                      //   "linear-gradient(to right, #ee7724, #d8363a, #dd3675, #b44593)",
                    }
                  }
                >
                  <img
                    className="w-[350px]"
                    src="/images/logoContacto.png"
                    alt=""
                  />
                  {/* <h2 className="flex  mx-auto font-montserrat font-bold text-6xl text-red-primary ">Contacto</h2>
                       <h2 className="flex  mx-auto font-montserrat font-bold text-6xl text-beige-secondary ">mascota</h2> */}
                  <img
                    className=" mt-[20px]"
                    src="/images/contactoMascota.png"
                    alt=""
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default Register;
