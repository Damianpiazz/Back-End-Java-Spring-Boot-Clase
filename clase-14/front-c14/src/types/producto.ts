export interface ProductoDTO {
  id: number;
  nombre: string;
  precio: number;
  cantidadEnStock: number;
  descripcion: string;
  categoria: string;
}

export interface ProductoCreateDTO {
  nombre: string;
  precio: number;
  cantidadEnStock: number;
  descripcion: string;
  categoria: string;
}