package org.d3rpla4203.test

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum
import com.nightonke.boommenu.BoomButtons.OnBMClickListener
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton
import com.nightonke.boommenu.BoomMenuButton
import com.nightonke.boommenu.ButtonEnum
import com.nightonke.boommenu.Piece.PiecePlaceEnum
import com.nightonke.boommenu.Util
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.d3rpla4203.test.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
    val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home, container, false)

        val bmb: BoomMenuButton = binding.bmb as BoomMenuButton
      val aku =  bmb.setButtonEnum(ButtonEnum.TextOutsideCircle)
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_1)
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_1);

        for (i in 0 until bmb.getPiecePlaceEnum().pieceNumber()) {
            val builder: TextOutsideCircleButton.Builder = TextOutsideCircleButton.Builder()
            if (i == 1) {
                builder.normalImageRes(R.drawable.ison_kecelakaan_1_min).normalColorRes(R.color.color1)
                    .normalText("Lapor Kecelakaan").listener(object :
                    OnBMClickListener {
                    override fun onBoomButtonClick(index: Int) {

                    }
                })
            }
            if (i == 2) {
                builder.normalImageRes(R.drawable.icon_article_min).normalColorRes(R.color.color1).normalText("Artikel Kesehatan").listener(object :
                    OnBMClickListener {
                    override fun onBoomButtonClick(index: Int) {
                        view!!.findNavController().navigate(R.id.action_home2_to_artikle_kesehatan)
                    }
                })
            }

        if (i == 3) {
                builder.normalImageRes(R.drawable.icon_rainmeter_1_min).normalColorRes(R.color.color1).normalText("Tips Rainmeter").listener(object :
                    OnBMClickListener {
                    override fun onBoomButtonClick(index: Int) {
                        bmb.hideMoveEaseEnum

                        view!!.findNavController().navigate(R.id.action_home2_to_cuaca_panas)
                    }
                })
            }
            if (i == 0) {
                builder.normalImageRes(R.drawable.icon_sakit_1_min).normalColorRes(R.color.color1).normalText("Lapor Sakit").listener(object :
                    OnBMClickListener {
                    override fun onBoomButtonClick(index: Int) {
                    }
                })
            }
            bmb.addBuilder(builder)
        }
    return binding.root

    }

}
