import { Link, useNavigate } from "react-router-dom";
import Layout from "../../ui/Layout";
import { axiosMascota } from "../../config/axios.config";
import { useUserInfo } from "../../store/userInfo";
import { useContactoMascota } from "../../hooks/useContactoMascota";

const Login = () => {
  const { getUser } = useContactoMascota();
  const login = useUserInfo((state) => state.login);

  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    const data = Object.fromEntries(new FormData(e.target));
    console.log(data);

    axiosMascota
      .post("/auth/login", data)
      .then(({ data }) => {
        login(data);
        navigate("/");
        getUser();
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
                        Iniciar Sesión
                      </h4>
                    </div>

                    <form onSubmit={handleSubmit} className=" mx-5">
                      {/* <p className="mb-4 font-montserrat font-light ">Por favor, ingrese a su cuenta</p> */}
                      {/* <!--Username input--> */}
                      <div className="grid  mb-4">
                        <label htmlFor="">Correo</label>
                        <input
                          name="email"
                          type="text"
                          label="Username"
                          className="mb-4 border rounded-md"
                        ></input>
                      </div>

                      {/* <!--Password input--> */}
                      <div className="grid  mb-2">
                        <label htmlFor="">Contraseña</label>
                        <input
                          name="password"
                          type="password"
                          label="Password"
                          className="mb-4 border rounded-md"
                        ></input>
                      </div>

                      {/* <!--Submit button--> */}
                      <div className="mb-6 pb-1 pt-1 text-center">
                        <button
                          className="mb-3 inline-block w-full rounded px-6 pb-2 pt-2.5 text-xs font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_rgba(0,0,0,0.2)] transition duration-150 ease-in-out hover:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)] focus:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)] focus:outline-none focus:ring-0 active:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)]"
                          //type="button"
                          style={{
                            background:
                              "linear-gradient(to right, #BB2649, #F35D74, #FFC3D4, #BB2649 )",
                          }}
                        >
                          Iniciar sesión
                        </button>
                      </div>

                      <div className="flex items-center justify-between pb-6">
                        <p className="mb-0 mr-2">No tienes una cuenta?</p>
                        <Link to={"/auth/register"}>
                          <button
                            type="button"
                            className="bg-[#FFD6A5] inline-block rounded  border-danger px-6 pb-[6px] pt-2 text-xs font-medium uppercase leading-normal text-danger transition duration-150 ease-in-out hover:border-danger-600 hover:bg-neutral-500 hover:bg-opacity-10 hover:text-danger-600 focus:border-danger-600 focus:text-danger-600 focus:outline-none focus:ring-0 active:border-danger-700 active:text-danger-700 dark:hover:bg-neutral-100 dark:hover:bg-opacity-10"
                          >
                            Registrate
                          </button>
                        </Link>
                      </div>
                    </form>
                  </div>
                </div>

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

export default Login;
