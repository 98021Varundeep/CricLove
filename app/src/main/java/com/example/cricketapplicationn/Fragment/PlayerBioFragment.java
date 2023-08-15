package com.example.cricketapplicationn.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricketapplicationn.Manager.RequestManager;
import com.example.cricketapplicationn.Model.PlayerInfo;
import com.example.cricketapplicationn.Model.Value;
import com.example.cricketapplicationn.PlayerActivity;
import com.example.cricketapplicationn.PlayerInfoListener;
import com.example.cricketapplicationn.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class PlayerBioFragment extends Fragment {

    ImageView profilePic;
    TextView playerName, country, born, birthPlace, nickName, height, role, battingSytle, bowlingstyle, teams, profile;
    ProgressDialog dialog;
    RequestManager manager;
    int playerId;

    public PlayerBioFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_player_bio, container, false);
 //         return inflater.inflate(R.layout.fragment, container, false)
//        if (savedInstanceState != null) {

  //          int playerId = getArguments().getInt("playerId");
    //    }
        //

 //           Toast.makeText(getContext(), "Null player id", Toast.LENGTH_LONG).show();
        PlayerActivity activity = (PlayerActivity) getActivity();

        Bundle results = activity.getMyData();
      if(results!=null) {

          playerId = results.getInt("playerId");
    //      Toast.makeText(activity, playerId+"", Toast.LENGTH_SHORT).show();

      }
      else {
          Toast.makeText(activity, "Bubdle is empty", Toast.LENGTH_LONG).show();

          Toast.makeText(getContext(), "Bundle Empty", Toast.LENGTH_LONG).show();
      }

      //  output.setText(value1);
      //  return rootView;
        dialog = new ProgressDialog(getContext());
        profilePic = view.findViewById(R.id.profile_image_bio);
        playerName = view.findViewById(R.id.playerName_bio);
        country = view.findViewById(R.id.countryName_bio);
        born = view.findViewById(R.id.born_bio);
        birthPlace = view.findViewById(R.id.birthPlace_bio);
        nickName = view.findViewById(R.id.nickName_bio);
        height = view.findViewById(R.id.height_bio);
        role = view.findViewById(R.id.role_bio);
        battingSytle = view.findViewById(R.id.battingStyle_bio);
        bowlingstyle = view.findViewById(R.id.bowlingStyle_bio);
        teams = view.findViewById(R.id.teams_bio);
        profile = view.findViewById(R.id.profile_bio);

        dialog.setTitle("Loading Profile..");
        dialog.show();
         manager=new RequestManager(getContext());
         manager.getPlayerInfo(listener,playerId);
        return view;
    }

    private final PlayerInfoListener listener = new PlayerInfoListener() {
        @Override
        public void didFectch(PlayerInfo info, String message) {
        dialog.hide();
            if (info == null) {
                Toast.makeText(getContext(), "Can not Load Data", Toast.LENGTH_SHORT).show();

            }
            else{
             PlayerInfo playerInfo=info;

                Picasso.get()
                                .load(playerInfo.image)
                        .placeholder(R.drawable.ic_person__2_)
                                        .into(profilePic);
                playerName.setText(playerInfo.name);
                country.setText(playerInfo.intlTeam);
                born.setText(playerInfo.doB);
                birthPlace.setText(playerInfo.birthPlace);
                nickName.setText(playerInfo.nickName);
                height.setText(playerInfo.height);
                role.setText(playerInfo.role); ;
                battingSytle.setText(playerInfo.bat);
                bowlingstyle.setText(playerInfo.bowl);
                teams.setText(playerInfo.teams);
                profile.setText(playerInfo.bio);

            }


        }

        @Override
        public void didError(String message) {
         dialog.hide();
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };
}