import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.cmt.databinding.ItemVehicleTypeBinding

class VehicleTypeAdapter : RecyclerView.Adapter<VehicleTypeAdapter.ViewHolder>() {

    private var vehicleTypes: List<VehicleType> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemVehicleTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(vehicleTypes[position])
    }

    override fun getItemCount(): Int = vehicleTypes.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<VehicleType>) {
        vehicleTypes = newList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemVehicleTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(vehicleType: VehicleType) {
            binding.vehicleName.text = vehicleType.text
        }
    }
}
