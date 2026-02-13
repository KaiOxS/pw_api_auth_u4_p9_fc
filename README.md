# pw_api_auth_u4_p9_fc

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/pw_api_auth_u4_p9_fc-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON Binding support
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more
- SmallRye JWT Build ([guide](https://quarkus.io/guides/security-jwt-build)): Create JSON Web Token with SmallRye JWT Build API

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)




































































<!--
***Conexion entre tablas:
 
Entidad 
@OneToMany(mappedBy = "estudiante", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Hijo> hijos;
 
Representation, agrega la variable para guardar los links.
private List<LinkDto> links;
 
 
Metodo en el resourse:
private EstudianteRepresentation construirLinks(EstudianteRepresentation er){
        String self = this.uriInfo.getBaseUriBuilder().path(EstudianteResource.class).path(String.valueOf(er.getId())).build().toString();
        String hijos = this.uriInfo.getBaseUriBuilder().path(EstudianteResource.class).path(String.valueOf(er.getId())).path("hijos").build().toString();
        er.setLinks(List.of(new LinkDto(self,"self"), new LinkDto(hijos,"hijos"))); 
        return er;
}
 
	Uso del metodo. 
	public EstudianteRepresentation consultarPorId(@PathParam("id") Integer iden) {
        	return this.construirLinks(this.estudianteService.consultarPorId(iden));
 
	}
 
***Como se linkea en resourse
@PUT
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RolesAllowed("admin")
public Response actualizar(@PathParam("id") Integer id, EstudianteRepresentation esstu){
     this.estudianteService.actualizar(id, esstu);
     return Response.status(209).entity(null).build();
}
 
 
***Obtener tocken
import axios from "axios";
const URL = "http://localhost:8082/matricula/api/v1.0/autorizacion/token?user=John&password=1234";
const obtenerToken = async () => {
    const token = await axios.get(`${URL}`).then(r => r.data);
    console.log(token);
    return token.token;
}
export const obtenerTokenFachada = async () => {
    return await obtenerToken();
}
 
 
++Como usar dicho token
import axios from "axios";
import { obTokenFacade } from "../clients/ObtenerTockenClient.js";
 
const URL = 'http://localhost:8080/citamedica/api/v1.0/pacientes';
 
const consultarTodos = async () => {
    const TOKEN = await obTokenFacade(); //
    const res = await axios.get(`${URL}`, { headers: { Authorization: `Bearer ${TOKEN}` } }).then(r=>r.data);
    return res;
}
 
***Configuración de un guardia:

{
		path: '/consultarTodos',
		name: 'consultarTodos',
		component: ConsultarTodosView,
		meta: {
			requiereAutorizacion: false,
			esPublica: false
		}
	},

/*Configuracion del guardian de rutas*/
router.beforeEach((to, from, next) => {
	if (to.meta.requiereAutorizacion) {
		const estaAutenticado = localStorage.getItem("estaAutenticado");
		const token = localStorage.getItem("token");

		if (! estaAutenticado) {
			console.log("Redirigiendo al Login");
			next({name: 'login'})
		} else {
			next();
		}

		/*Le envio a una página de login*/
	} else {
		console.log("Pase Libre")
		next();
		/*Le dejo que pase sin autenticación*/
	}
})
package uce.edu.web.api.matricula.application.representation;

public class LinkDto {

    private String href;
    private String rel;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public LinkDto() {

    }

    public LinkDto(String href, String rel) {
        this.href = href;
        this.rel = rel;
    }

}
 



-->