import axiosInstance from "@/lib/axiosInstance";
import { ProductoDTO, ProductoCreateDTO } from "@/types/producto";

export async function listarProductos(): Promise<ProductoDTO[]> {
  const response = await axiosInstance.get<ProductoDTO[]>("/productos");
  return response.data;
}

export async function obtenerProductoPorId(id: number): Promise<ProductoDTO> {
  const response = await axiosInstance.get<ProductoDTO>(`/productos/${id}`);
  return response.data;
}

export async function crearProducto(producto: ProductoCreateDTO): Promise<ProductoDTO> {
  const response = await axiosInstance.post<ProductoDTO>("/productos", producto);
  return response.data;
}

export async function actualizarProducto(id: number, producto: ProductoCreateDTO): Promise<ProductoDTO> {
  const response = await axiosInstance.put<ProductoDTO>(`/productos/${id}`, producto);
  return response.data;
}

export async function eliminarProducto(id: number): Promise<void> {
  await axiosInstance.delete(`/productos/${id}`);
}