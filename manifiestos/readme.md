# Guía de Ejecución de TaskRuns de Tekton para la construcción de la aplicación Java

## Clonación del código fuente de la aplicación
El primer paso para crear la imagen de la aplicación Java es clonar el código fuente de la aplicación. Para ello:
* Debes de asegurarte de que el Task de git-clone ya se encuentra en el cluster de Kubernetes. Si no es así, debes de crearlo.
* Debes de crear el taskrun que utilice el task de git-clone. Para ello, debes de crear el taskrun definido en el archivo [taskrun-git-clone.yaml](taskruns/taskrun-git-clone.yaml). Para crear el taskrun, ejecuta el siguiente comando:

```bash
kubectl create -f taskrun-git-clone.yaml
```
![Git Clone TaskRun Creation](images/GitClonecreateTR.png)

* Debes de comprobar que el taskrun se ha ejecutado correctamente. Para ello, consultamos el log de salida:

```bash
kubectl logs git-clone-[xxx]
```

![Git Clone TaskRun Log](images/GitCloneLogTR.png)

### Comprobación de la clonación del código fuente
Es posible comprobar que el código fuente ha sido clonado con éxito, ejecutando el taskrun de listDirectory
 Para ello:
* Debes de asegurarte de que el Task de list-directory ya se encuentra en el cluster de Kubernetes. Si no es así, debes de crearlo.
* Debes de crear el taskrun que utilice el task de list-directory. Para ello, debes de crear el taskrun definido en el archivo [listDirectory.yaml](taskruns/listDirectory.yaml). Para crear el taskrun, ejecuta el siguiente comando:

```bash
kubectl create -f listDirectory.yaml
```
![List Directory TaskRun Creation](images/ListDirCreateTR.png)

* Debes de comprobar que el taskrun se ha ejecutado correctamente. Para ello, consultamos el log de salida:

```bash
kubectl logs listdirectory-[xxx]
```

![List Directory TaskRun Log](images/ListDirLogTR.png)

## Construcción de la imagen de la aplicación Java
Una vez que el código fuente ha sido clonado con éxito, el siguiente paso es construir la imagen de la aplicación Java. Para ello:
* Debes de asegurarte de que el Task de maven ya se encuentra en el cluster de Kubernetes. Si no es así, debes de crearlo.
* Debes de crear el taskrun que utilice el task de maven. Para ello, debes de crear el taskrun definido en el archivo [mavenTaskrun.yaml](taskruns/mavenTaskrun.yaml). Para crear el taskrun, ejecuta el siguiente comando:

```bash
kubectl create -f maventaskrun.yaml
```
![Maven TaskRun Creation](images/MavenCreateTR.png)

* Debes de comprobar que el taskrun se ha ejecutado correctamente. Para ello, consultamos el log de salida:

```bash
kubectl logs maven-[xxx]
```

![Maven TaskRun Log](images/MavenLogTR.png)

## Push de la imagen de la aplicación Java al registro de imágenes
Una vez que la imagen de la aplicación Java ha sido construida con éxito, el siguiente paso es subir la imagen al registro de imágenes. Para ello:
* Debes de asegurarte de que el Task de buildah ya se encuentra en el cluster de Kubernetes. Si no es así, debes de crearlo.
* Debes de crear el taskrun que utilice el task de buildah. Para ello, debes de crear el taskrun definido en el archivo [buildhaTaskrun.yaml](taskruns/buildhaTaskrun.yaml). No olvides cambiar la versión de la imagen en el archivo [buildhaTaskrun.yaml](taskruns/buildhaTaskrun.yaml) antes de crear el taskrun. Para crear el taskrun, ejecuta el siguiente comando:

```bash
kubectl create -f buildhaTaskrun.yaml
```
![Buildah TaskRun Creation](images/BuildahCreateTR.png)

* Debes de comprobar que el taskrun se ha ejecutado correctamente. Para ello, consultamos el log de salida:

```bash
kubectl logs buildah-[xxx]
```

![Buildah TaskRun Log](images/BuildahLogTR.png)